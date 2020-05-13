package simulation;

import java.util.Random;

import simulation.graphics.Window;
import simulation.tree.Tree;

public class Simulation {

    public static Simulation simulation;
    public static Random random = new Random(1);

    private final Tree tree;
    private final Environment environment;
    private final int maxIterations = 1600;

    /**
     * Constructor for creating the Simulation
     */
    Simulation() {
        tree = new Tree();
        environment = new Environment();

        Window.setup(tree);
        IntervalTasks.setup(tree, maxIterations);
    }

    Environment getEnvironment() {
        return environment;
    }

    /**
     * @param args Main function arguments
     */
    public static void main(final String[] args) {
        simulation = new Simulation();
    }

}
