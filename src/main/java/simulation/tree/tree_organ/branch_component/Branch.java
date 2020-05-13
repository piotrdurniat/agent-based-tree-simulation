package simulation.tree.tree_organ.branch_component;

import java.util.Random;
import java.util.ArrayList;
import java.lang.Math;

import simulation.tree.tree_organ.TreeOrgan;
import simulation.tree.tree_organ.branch_component.subcomponents.Leaf;
import simulation.tree.tree_organ.branch_component.subcomponents.Flower;

public class Branch extends BranchComponent {

    private float angle;
    private float length;
    private float diameter;

    private ArrayList<BranchComponent> components;
    private Random random;

    private ArrayList<Float> angleOptions;

    private static final int maxBranchNum = 6;

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

        graphics = new BranchGraphics(this);
        random = new Random();
    }

    @Override
    public void evaluateTurn() {
        for (BranchComponent component : components) {
            component.evaluateTurn();
        }

        if (length > 50 && random.nextInt(100) < 1) {
            this.makeBranch(); // Temporary solution for testing
        }

        if (random.nextInt(100) < 0.5) {
            this.makeLeaf(); // Temporary solution for testing
        }

        if (random.nextInt(1000) < 1) {
            this.makeFlower(); // Temporary solution for testing
        }

        if (length < 200) {
            length += 0.2;
        }

        diameter += 0.008;
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

        BranchComponent childBranch = new Branch(this, angle, 1, 1);

        components.add(childBranch);
    }

    private void makeLeaf() {
        BranchComponent leaf = new Leaf(this);
        components.add(leaf);
    }

    private void makeFlower() {
        BranchComponent flower = new Flower(this);
        components.add(flower);
    }
}