package simulation.tree;

// import simulation.tree.tree_organ.branch_component.BranchComponent;
import simulation.tree.tree_organ.branch_component.Branch;
import simulation.graphics.ComponentGraphics;
import simulation.graphics.GraphicalComponent;
import simulation.tree.tree_organ.TreeOrgan;
import simulation.tree.tree_organ.RootSystem;

public class Tree implements GraphicalComponent {

    private TreeOrgan trunk;
    private TreeOrgan rootSystem;

    private ComponentGraphics graphics;

    /**
     * Constructor for creating object of type Tree
     */
    public Tree() {
        rootSystem = new RootSystem();
        trunk = new Branch(rootSystem, 0, 1, 1);

        graphics = new TreeGraphics(this);
    }

    /**
     * Returns the graphics object for drawing this tree
     * 
     * @return The graphics object
     */
    public ComponentGraphics getGraphics() {
        return graphics;
    }

    /**
     * @return The trunk of this tree
     */
    public TreeOrgan getTrunk() {
        return trunk;
    }

    /**
     * @return The rootSystem of this tree
     */
    public TreeOrgan getRootSystem() {
        return rootSystem;
    }

    /**
     * Evaluates turns of trunk and rootSystem
     */
    public void evaluateTurn() {
        trunk.evaluateTurn();
        rootSystem.evaluateTurn();
    }
}