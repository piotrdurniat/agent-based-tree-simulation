package simulation;

import java.util.List;

import simulation.tree.tree_organ.RootSystem;
import simulation.tree.tree_organ.TreeOrgan;
import simulation.tree.tree_organ.branch_component.Branch;
import simulation.tree.tree_organ.branch_component.subcomponents.Flower;
import simulation.tree.tree_organ.branch_component.subcomponents.Fruit;
import simulation.tree.tree_organ.branch_component.subcomponents.Leaf;

public class Results {

    private static int treeOrganNum = 0;
    private static int branchNum = 0;
    private static int leafNum = 0;
    private static int flowerNum = 0;
    private static int fruitNum = 0;
    private static int rootSystemNum = 0;

    private static int maxIterations = Configuration.maxIterations;

    /**
     * Calculates and saves the quantity of every individual tree organ type.
     */
    private static void getResults() {
        List<TreeOrgan> treeOrgans = Simulation.simulation.getTreeOrgans();

        treeOrganNum = treeOrgans.size();

        for (TreeOrgan organ : treeOrgans) {
            if (organ instanceof Branch)
                branchNum++;
            else if (organ instanceof Leaf)
                leafNum++;
            else if (organ instanceof Flower)
                flowerNum++;
            else if (organ instanceof Fruit)
                fruitNum++;
            else if (organ instanceof RootSystem)
                rootSystemNum++;
        }
    }

    /**
     * Prints the results of the simulation to the terminal
     */
    public static void print() {

        getResults();

        System.out.println("Simulation results: ");
        System.out.println("Number of turns: " + maxIterations);
        System.out.println("Final number of tree organs: " + treeOrganNum);
        System.out.println("Number of individual organ types: ");
        System.out.println("Branches: " + branchNum);
        System.out.println("Leaves: " + leafNum);
        System.out.println("Fruits: " + fruitNum);
        System.out.println("Flowers: " + flowerNum);
        System.out.println("Root systems: " + rootSystemNum);
    }
}