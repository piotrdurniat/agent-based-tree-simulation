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
     * @return The environment object
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * @return List of all tree organs on the tree
     */
    public List<TreeOrgan> getTreeOrgans() {
        return tree.getOrgans();
    }

    /**
     * @param args Main function arguments
     */
    public static void main(final String[] args) {
        try {
            Configuration.loadConfig();
        } catch (Exception exception) {
            System.out.println(exception);
        }
        simulation = new Simulation();
    }

}
