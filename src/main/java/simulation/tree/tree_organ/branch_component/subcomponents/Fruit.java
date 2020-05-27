package simulation.tree.tree_organ.branch_component.subcomponents;

import java.awt.Graphics;

import simulation.Configuration;
import simulation.tree.tree_organ.branch_component.Branch;

public class Fruit extends BranchSubcomponent {

    private float ripeness;
    private static float ripeningSpeed = Configuration.fruitRipeningSpeed;

    /**
     * Constuctor for creating a new Fruit object
     * 
     * @param parentBranch The branch on which the fruit grows
     */
    public Fruit(Branch parentBranch) {
        super(parentBranch);

        graphics = new FruitGraphics(this);
        ripeness = 0;
    }

    @Override
    public void evaluateTurn() {
        checkIfRipe();
        grow();
    }

    /**
     * Checks if the fruit is ripe. If the fruit is ripe it falls.
     */
    private void checkIfRipe() {
        if (ripeness >= 1) {
            fall();
        }
    }

    /**
     * Grows this fruit
     */
    private void grow() {
        if (parentBranch.getGlucose(2) > 0) {
            ripeness += ripeningSpeed;
        }
    }

    /**
     * @return The ripeness amount (between 0 and 1)
     */
    public float getRipeness() {
        return ripeness;
    }

    /**
     * Draws the fruit on the window
     */
    public void show(Graphics g) {
        graphics.show(g);
    }
}