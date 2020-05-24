package simulation.tree.tree_organ;

import simulation.Simulation;

public class RootSystem extends TreeOrgan {

    @Override
    public void evaluateTurn() {

    }

    public float getWater() {
        return Simulation.simulation.getEnvironment().getWater();
    }
}