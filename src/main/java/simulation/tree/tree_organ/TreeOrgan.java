package simulation.tree.tree_organ;

public abstract class TreeOrgan {

    /**
     * Gets water from another object and returns it's amount
     * 
     * @return The water amount
     */
    public abstract float getWater();

    /**
     * Performs every action in tree organ's turn
     */
    public abstract void evaluateTurn();
}