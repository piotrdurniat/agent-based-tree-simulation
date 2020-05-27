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
     * @return ComponentGraphics Returns graphics object for drawing this Tree
     */
    public ComponentGraphics getGraphics() {
        return graphics;
    }

    /**
     * @return TreeOrgan Returns this tree's trunk
     */
    public TreeOrgan getTrunk() {
        return trunk;
    }

    /**
     * @return TreeOrgan Returns this tree's root system
     */
    public TreeOrgan getRootSystem() {
        return rootSystem;
    }

    /**
     * Evaluates the turn of every tree organ
     */
    public void evaluateTurn() {
        trunk.evaluateTurn();
        rootSystem.evaluateTurn();
    }
}