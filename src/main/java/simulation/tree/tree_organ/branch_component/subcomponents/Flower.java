package simulation.tree.tree_organ.branch_component.subcomponents;

import simulation.Configuration;
import simulation.tree.tree_organ.branch_component.Branch;

public class Flower extends BranchSubcomponent {

    private float diameter = 1;
    private static float minLight = Configuration.leafMinLight;
    private static float maxDiameter = Configuration.flowerMaxDiameter;
    private static float growthSpeeed = Configuration.flowerGrowthSpeed;
    private static float glucosePerFruit = Configuration.glucosePerFruit;

    public Flower(Branch parentBranch) {
        super(parentBranch);

        graphics = new FlowerGraphics(this);
    }

    @Override
    public void evaluateTurn() {
        checkLightConditions();
        grow();
        tryToTurnIntoFruit();
    }

    /**
     * Checks all requirements for turning into fruit.
     * 
     * If all requirements are met, than invokes a function for changing into fruit
     */
    private void tryToTurnIntoFruit() {
        if (diameter <= maxDiameter)
            return;
        if (parentBranch.getGlucose(glucosePerFruit) != 0)
            return;
        turnIntoFruit();
    }

    /**
     * Removes itself from the branch and adds a new fruit on it's place
     */
    private void turnIntoFruit() {
        fall();
        parentBranch.makeFruit();
    }

    /**
     * Checks the amount of light reaching this flower. If there is not enough
     * light, the flower falls
     */
    private void checkLightConditions() {
        if (parentBranch.getLight() < minLight)
            fall();
    }

    /**
     * Makes the flower grow in diameter
     */
    private void grow() {
        if (diameter >= maxDiameter)
            return;
        float glucose = parentBranch.getGlucose(1);
        if (glucose > 0) {
            diameter += growthSpeeed;
        }
    }

    /**
     * @return float Returns the diameter of this flower
     */
    public float getDiameter() {
        return diameter;
    }

}