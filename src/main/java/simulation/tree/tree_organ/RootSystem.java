package simulation.tree.tree_organ;

import simulation.Configuration;
import simulation.Simulation;

public class RootSystem extends TreeOrgan {

    private float efficiency = 0.7f;
    private static float growthSpeed = Configuration.rootSystemGrowthSpeed;

    /**
     * Evaluates the turn of this root system
     */
    @Override
    public void evaluateTurn() {
        grow();
    }

    /**
     * Increases the efficiency of this root system
     * 
     * The efficiency describes how much water from the environment is being
     * transported by this root system
     */
    private void grow() {
        if (efficiency <= 1) {
            efficiency += growthSpeed;
        }
    }

    /**
     * Takes water from the environment and returns its amount
     * 
     * The higher the efficiency, the more water it returns
     */
    public float getWater() {
        return Simulation.simulation.getEnvironment().getWater() * efficiency;
    }
}