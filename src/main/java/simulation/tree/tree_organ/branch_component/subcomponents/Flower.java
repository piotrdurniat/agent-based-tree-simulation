package simulation.tree.tree_organ.branch_component.subcomponents;

import simulation.Configuration;
import simulation.tree.tree_organ.branch_component.Branch;

public class Flower extends BranchSubcomponent {

    private float diameter = 1;
    private static float minLight = Configuration.leafMinLight;

    public Flower(Branch parentBranch) {
        super(parentBranch);

        graphics = new FlowerGraphics(this);
    }

    @Override
    public void evaluateTurn() {
        checkLightConditions();
        grow();
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
        if (diameter >= Configuration.flowerMaxDiameter)
            return;
        float glucose = parentBranch.getGlucose(1);
        if (glucose > 0) {
            diameter += Configuration.flowerGrowthSpeed;
        }
    }

    /**
     * @return float Returns the diameter of this flower
     */
    public float getDiameter() {
        return diameter;
    }

}