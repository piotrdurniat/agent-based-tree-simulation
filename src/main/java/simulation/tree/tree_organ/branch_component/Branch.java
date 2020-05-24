package simulation.tree.tree_organ.branch_component;

import java.util.ArrayList;
import java.lang.Math;

import simulation.Configuration;
import simulation.Simulation;
import simulation.tree.tree_organ.TreeOrgan;
import simulation.tree.tree_organ.branch_component.subcomponents.Leaf;
import simulation.tree.tree_organ.branch_component.subcomponents.Flower;

public class Branch extends BranchComponent {

    private float angle;
    private float length;
    private float diameter;
    private float glucose;

    private ArrayList<BranchComponent> components;
    private ArrayList<Branch> branches;

    private ArrayList<Float> angleOptions;

    private static final int maxBranchNum = Configuration.branchingFactor;

    /**
     * Constructor for creating a Branch object
     * 
     * @param parentOrgan The organ from which the new branch grows
     * @param angle       The angle at which the branch grows relative to parent
     * @param length      The length of branch
     * @param diameter    The diameter of branch
     */
    public Branch(TreeOrgan parentOrgan, float angle, float length, float diameter) {
        super(parentOrgan);
        this.angle = angle;
        this.length = length;
        this.diameter = diameter;

        angleOptions = new ArrayList<Float>();

        for (int i = 0; i < maxBranchNum / 2; i++) {
            angleOptions.add((float) ((2 * i + 1) * Math.PI / 16));
            angleOptions.add((float) (-(2 * i + 1) * Math.PI / 16));
        }

        components = new ArrayList<BranchComponent>();
        branches = new ArrayList<Branch>();

        graphics = new BranchGraphics(this);
    }

    @Override
    public void evaluateTurn() {
        for (BranchComponent component : new ArrayList<BranchComponent>(components)) {
            component.evaluateTurn();
        }

        if (length > 50 && randomEvent(Configuration.newBranchProbability)) {
            this.makeBranch();
        }

        if (randomEvent(Configuration.newLeafProbability) && getLight() >= Configuration.leafMinLight) {
            this.makeLeaf();
        }

        // if (randomEvent(Configuration.newFlowerProbability)) {
        // this.makeFlower();
        // }

        if (length < Configuration.maxBranchLength) {
            length += 0.2;
        }

        diameter += 0.008;
    }

    /**
     * Returns boolean value with a given probability
     * 
     * @param probability float The probability of returning true
     * @return boolean Returns true or false with a given probability
     */
    boolean randomEvent(float probability) {
        return random.nextFloat() < probability;
    }

    /**
     * @return float Returns the angle of this branch
     */
    float getAngle() {
        return angle;
    }

    /**
     * @return float Returns the length of this branch
     */
    public float getLength() {
        return length;
    }

    /**
     * @return float Returns the diameter of this branch
     */
    float getDiameter() {
        return diameter;
    }

    /**
     * @return ArrayList<BranchComponent> Returns all sub components of this branch
     */
    ArrayList<BranchComponent> getComponents() {
        return components;
    }

    /**
     * Creates new branch and adds it to this branch's components
     */
    private void makeBranch() {
        if (angleOptions.size() == 0) {
            return;
        }

        int index = random.nextInt(angleOptions.size());
        float angle = (float) angleOptions.get(index);
        angleOptions.remove(index);

        Branch childBranch = new Branch(this, angle, 1, 1);

        branches.add(childBranch);
        components.add((BranchComponent) childBranch);
    }

    /**
     * @return int Returns number of branches that are above this branch and
     *         connected to it
     */
    private int getNumberOfBranchesAbove() {
        if (branches.size() == 0)
            return 0;
        int num = 0;
        for (Branch branch : branches) {
            num += 1 + branch.getNumberOfBranchesAbove();
        }
        return num;
    }

    /**
     * @return float Returns shade amount betweeen 0 -1 (1 means 100% shade and no
     *         light reaches this branch. 0 means 0% shade and all light reaches
     *         this branch)
     */
    private float shade() {
        int branchesAbove = getNumberOfBranchesAbove();
        if (branchesAbove > 10)
            return 1;
        return (float) branchesAbove / 10;
    }

    /**
     * @return float Returns the amount of light reaching this branch
     */
    public float getLight() {
        return Simulation.simulation.getEnvironment().getLight() * (1 - shade());
    }

    /**
     * Gets water from parent organ and returns it's amount
     */
    public float getWater() {
        return parentOrgan.getWater() * 0.9f;
    }

    /**
     * Adds a given amount of glucose to this branch
     * 
     * @param glucose The amount of glucose to add
     */
    public void addGlucose(float glucose) {
        this.glucose += glucose;
    }

    /**
     * Removes a given component from this branch
     * 
     * @param component BranchComponent The component to remove
     */
    public void removeComponent(BranchComponent component) {
        components.remove(component);
    }

    /**
     * Creates a new leaf and adds it to the components list
     */
    private void makeLeaf() {
        BranchComponent leaf = new Leaf(this);
        components.add(leaf);
    }

    /**
     * Creates a new flower and adds it to the components list
     */
    private void makeFlower() {
        BranchComponent flower = new Flower(this);
        components.add(flower);
    }
}