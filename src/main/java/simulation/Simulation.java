package simulation;

import simulation.graphics.Window;
import simulation.tree.Tree;

public class Simulation {

    public static Simulation simulation;

    private Tree tree;
    private int maxIterations = 1600;

    /**
     * Constructor for creating the Simulation
     */
    Simulation() {
        tree = new Tree();

        Window.setup(tree);
        IntervalTasks.setup(tree, maxIterations);
    }

    /**
     * @param args Main function arguments
     */
    public static void main(String[] args) {
        simulation = new Simulation();
    }

}
