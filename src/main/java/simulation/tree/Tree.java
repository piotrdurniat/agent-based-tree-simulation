package simulation.tree;

// import simulation.tree.tree_organ.branch_component.BranchComponent;
import simulation.tree.tree_organ.branch_component.Branch;
import simulation.graphics.ComponentGraphics;
import simulation.tree.tree_organ.TreeOrgan;
import simulation.tree.tree_organ.RootSystem;
import java.util.ArrayList;

public class Tree {

    private ArrayList<TreeOrgan> treeOrgans;

    private ComponentGraphics graphics;

    /**
     * Constructor for creating object of type Tree
     */
    public Tree() {

        treeOrgans = new ArrayList<TreeOrgan>();

        TreeOrgan root = new RootSystem();
        TreeOrgan trunk = new Branch(root, 0, 1, 1);

        treeOrgans.add(root);
        treeOrgans.add(trunk);

        graphics = new TreeGraphics(this);

    }

    /**
     * @return ComponentGraphics Returns graphics object for drawing this Tree
     */
    public ComponentGraphics getGraphics() {
        return graphics;
    }

    /**
     * @return ArrayList<TreeOrgan> Returns this tree's organs
     */
    public ArrayList<TreeOrgan> getTreeOrgans() {
        return treeOrgans;
    }

    /**
     * Evaluates the turn of every tree organ
     */
    public void evaluateTurn() {
        for (TreeOrgan organ : treeOrgans) {
            organ.evaluateTurn();
        }
    }
}