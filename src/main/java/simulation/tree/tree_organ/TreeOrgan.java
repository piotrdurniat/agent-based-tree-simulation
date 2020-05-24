package simulation.tree.tree_organ;

import simulation.graphics.ComponentGraphics;

public abstract class TreeOrgan {

    protected ComponentGraphics graphics;

    public TreeOrgan() {

    }

    /**
     * @return Graphics Returns graphics object for drawing this tree organ
     */
    public ComponentGraphics getGraphics() {
        return graphics;
    }

    abstract public float getWater();

    public abstract void evaluateTurn();
}