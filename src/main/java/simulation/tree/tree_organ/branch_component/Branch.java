package simulation.tree.tree_organ.branch_component;

import java.util.ArrayList;

import simulation.Configuration;
import simulation.Simulation;
import simulation.tree.tree_organ.TreeOrgan;
import simulation.tree.tree_organ.branch_component.subcomponents.Leaf;
import simulation.tree.tree_organ.branch_component.subcomponents.Flower;
import simulation.tree.tree_organ.branch_component.subcomponents.Fruit;

public class Branch extends BranchComponent {

    private float angle;
    private float length;
    private float diameter;
    private float glucose;

    private ArrayList<BranchComponent> components;
    private ArrayList<Branch> branches;
    private ArrayList<Float> availableAngles;

    private static final ArrayList<Float> angles = new ArrayList<>();
    private static final int maxBranchNum = Configuration.branchingFactor;
    private static final float angleBetweenBranches = Configuration.angleBetweenBranches;
    private static final float growthSpeed = Configuration.branchGrowthSpeed;

    static {
        float minAngle = -(0.5f * (maxBranchNum - 1)) * angleBetweenBranches;
        for (int i = 0; i < maxBranchNum; i++) {
            angles.add(minAngle + i * angleBetweenBranches);
        }
    }

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

        availableAngles = new ArrayList<Float>(angles);

        components = new ArrayList<BranchComponent>();
        branches = new ArrayList<Branch>();

        graphics = new BranchGraphics(this);

        // Initial glucose value
        this.glucose = Configuration.glucosePerBranch * 0.3f;
    }

    @Override
    public void evaluateTurn() {
        for (BranchComponent component : new ArrayList<BranchComponent>(components)) {
            component.evaluateTurn();
        }

        checkNewBranchRequirements();

        checkNewLeafRequirements();

        checkNewFlowerRequirements();

        grow();
    }

    /**
     * Makes the branch grow
     */
    private void grow() {
        growInLength();
        growInDiameter();
    }

    /**
     * Makes this branch grow in length
     * 
     * Branch grows faster if it has a lot of water and glucose
     */
    private void growInLength() {
        length += (getWater() + getGlucose(1)) * growthSpeed;
    }

    /**
     * Makes the branch grow in diameter.
     * 
     * The less water it has, the slower it will grow in diameter, so that the top
     * branches are thiner
     */
    private void growInDiameter() {
        diameter += 0.006 * getWater();
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

    public float getGlucose(float amount) {
        if (glucose >= amount) {
            glucose -= amount;
            return amount;
        }
        return 0;
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
     * Checks the requirements for creating a new branch.
     * 
     * Creates a new branch if all of the requirements are met
     */
    private void checkNewBranchRequirements() {
        if (!randomEvent(Configuration.newBranchProbability))
            return;
        if (availableAngles.size() == 0)
            return;
        if (getGlucose(Configuration.glucosePerBranch) == 0)
            return;

        makeBranch();
    }

    /**
     * Checks the requirements for creating a new leaf.
     * 
     * Creates a new leaf if all of the requirements are met
     */
    private void checkNewLeafRequirements() {
        if (!randomEvent(Configuration.newLeafProbability))
            return;
        if (getLight() < Configuration.leafMinLight)
            return;

        makeLeaf();
    }

    /**
     * Checks all requirements for creating a new flower.
     * 
     * Creates a new flower if all of the requirements are met
     */
    private void checkNewFlowerRequirements() {
        if (!randomEvent(Configuration.newFlowerProbability))
            return;
        if (getGlucose(Configuration.glucosePerFlower) == 0)
            return;
        if (getLight() < Configuration.flowerMinLight)
            return;

        makeFlower();
    }

    /**
     * Creates new branch and adds it to this branch's components
     */
    private void makeBranch() {
        int index = random.nextInt(availableAngles.size());
        float angle = (float) availableAngles.get(index);
        availableAngles.remove(index);

        Branch childBranch = new Branch(this, angle, 1, 1);

        branches.add(childBranch);
        components.add((BranchComponent) childBranch);
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

    public void makeFruit() {
        BranchComponent fruit = new Fruit(this);
        components.add(fruit);
    }
}