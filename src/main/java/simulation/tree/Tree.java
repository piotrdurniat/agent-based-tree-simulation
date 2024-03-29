package simulation.tree;

// import simulation.tree.tree_organ.branch_component.BranchComponent;
import simulation.tree.tree_organ.branch_component.Branch;
import simulation.tree.tree_organ.branch_component.BranchComponent;
import simulation.graphics.IGraphicalComponent;
import simulation.tree.tree_organ.TreeOrgan;
import simulation.tree.tree_organ.RootSystem;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

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
     * Returns the trunk of this tree
     * 
     * @return The trunk of this tree
     */
    TreeOrgan getTrunk() {
        return trunk;
    }

    /**
     * Returns the list of all organs in this tree
     * 
     * @return The list of all organs in this tree
     */
    public List<TreeOrgan> getOrgans() {
        List<TreeOrgan> organs = new ArrayList<>();
        organs.add(trunk);
        organs.add(rootSystem);

        List<BranchComponent> trunkComponents = ((Branch) trunk).getAllComponentsAbove();

        organs.addAll(trunkComponents);

        return organs;
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