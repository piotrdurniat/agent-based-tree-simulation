package simulation.tree;

// import simulation.tree.tree_organ.branch_component.BranchComponent;
import simulation.tree.tree_organ.branch_component.Branch;
import simulation.graphics.IGraphicalComponent;
import simulation.tree.tree_organ.TreeOrgan;
import simulation.tree.tree_organ.RootSystem;
import java.awt.Graphics;

public class Tree implements IGraphicalComponent {

    private TreeOrgan trunk;
    private TreeOrgan rootSystem;

    private IGraphicalComponent graphics;

    /**
     * Constructor for creating object of type Tree
     */
    public Tree() {
        rootSystem = new RootSystem();
        trunk = new Branch(rootSystem, 0, 1, 1);

        graphics = new TreeGraphics(this);
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

    /**
     * Draws this tree on the window
     **/
    public void show(Graphics g) {
        graphics.show(g);
    }

}