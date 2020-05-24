package simulation.tree.tree_organ.branch_component.subcomponents;

import simulation.Configuration;
import simulation.Simulation;
import simulation.tree.tree_organ.branch_component.Branch;

public class Leaf extends BranchSubcomponent {

    private static float minLight = Configuration.leafMinLight;

    public Leaf(Branch parentBranch) {
        super(parentBranch);

        graphics = new LeafGraphics(this);
    }

    @Override
    public void evaluateTurn() {
        checkLightConditions();
        doPhotosynthesis();
    }

    /**
     * Checks the amount of light reaching this leaf. If there is not enough light,
     * the leaf falls
     */
    private void checkLightConditions() {
        if (parentBranch.getLight() < minLight)
            this.fall();
    }

    /**
     * Removes this leaf from parent branch
     */
    private void fall() {
        parentBranch.removeComponent(this);
    }

    /**
     * Takes water from parent branch and returns it's amount
     */
    public float getWater() {
        return parentBranch.getWater();
    }

    /**
     * Does photosynthesis. Takes light, CO2 and water and turns it into glucose.
     */
    private void doPhotosynthesis() {
        float light = parentBranch.getLight();
        float carbonDioxide = Simulation.simulation.getEnvironment().getCarbonDioxide();
        float water = this.getWater();

        float glucose = (float) Math.pow(light * carbonDioxide * water, 1.0 / 3.0);

        parentBranch.addGlucose(glucose);
    }

}