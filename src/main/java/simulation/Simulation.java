package simulation;

import simulation.graphics.Window;
import simulation.tree.Tree;

public class Simulation {

    public static Simulation simulation;

    private Tree tree;

    /**
     * Constructor for creating the Simulation
     */
    Simulation() {
        tree = new Tree();

        Window.setup(tree);
        IntervalTasks.setup(tree);
    }

    /**
     * @param args Main function arguments
     */
    public static void main(String[] args) {
        simulation = new Simulation();
    }

}
