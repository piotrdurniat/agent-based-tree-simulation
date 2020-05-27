package simulation.tree.tree_organ.branch_component.subcomponents;

import java.awt.Graphics;

import simulation.Configuration;
import simulation.Simulation;
import simulation.tree.tree_organ.branch_component.Branch;

public class Leaf extends BranchSubcomponent {

    private float length;

    private static float minLight = Configuration.leafMinLight;

    /**
     * Constuctor for creating a new Leaf object
     * 
     * @param parentBranch The branch on which the leaf grows
     */
    public Leaf(Branch parentBranch) {
        super(parentBranch);
        graphics = new LeafGraphics(this);
        length = 1;
    }

    @Override
    public void evaluateTurn() {
        checkLightConditions();
        grow();
        doPhotosynthesis();
    }

    /**
     * @return The length of this leaf
     */
    float getLength() {
        return length;
    }

    /**
     * Makes the leaf grow in length
     */
    void grow() {
        if (length >= Configuration.maxLeafLength)
            return;
        float glucose = parentBranch.getGlucose(1);
        if (glucose > 0) {
            length += Configuration.leafGrowthSpeed;
        }
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
     * Does photosynthesis. Takes light, CO2 and water and turns it into glucose.
     */
    private void doPhotosynthesis() {
        float light = parentBranch.getLight();
        float carbonDioxide = Simulation.simulation.getEnvironment().getCarbonDioxide();
        float water = this.getWater();

        float glucose = (float) Math.pow(light * carbonDioxide * water, 1.0 / 3.0);

        parentBranch.addGlucose(glucose);
    }

    /**
     * Draws the leaf on the window
     */
    public void show(Graphics g) {
        graphics.show(g);
    }
}