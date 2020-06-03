package simulation;

import java.util.List;
import java.util.Random;

import simulation.graphics.Window;
import simulation.tree.Tree;
import simulation.tree.tree_organ.TreeOrgan;

public class Simulation {

    public static Simulation simulation;
    public static Random random = new Random(3);

    private final Tree tree;
    private final Environment environment;

    /**
     * Constructor for creating the Simulation
     */
    Simulation() {
        tree = new Tree();
        environment = new Environment();
        Window.setup(tree);
        IntervalTasks.setup(tree);
    }

    /**
     * Returns the environment object of this simulation
     * 
     * @return The environment object
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * Returns The list of all tree organs on the tree in this simulation
     * 
     * @return The list of all tree organs on the tree
     */
    public List<TreeOrgan> getTreeOrgans() {
        return tree.getOrgans();
    }

    /**
     * Main program method
     * 
     * @param args Main method arguments
     */
    public static void main(final String[] args) {
        Configuration.loadConfig();
        simulation = new Simulation();
    }

}
