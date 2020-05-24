package simulation.tree.tree_organ;

import simulation.Simulation;

public class RootSystem extends TreeOrgan {
    public RootSystem() {
        graphics = new RootSystemGraphics(this);
    }

    @Override
    public void evaluateTurn() {
        // TODO Auto-generated method stub

    }

    public float getWater() {
        return Simulation.simulation.getEnvironment().getWater();
    }
}