package simulation.tree.tree_organ.branch_component;

import java.util.Random;

import simulation.Simulation;
import simulation.graphics.IGraphicalComponent;
import simulation.tree.tree_organ.TreeOrgan;

public abstract class BranchComponent extends TreeOrgan implements IGraphicalComponent {

    TreeOrgan parentOrgan;
    protected Random random;
    protected IGraphicalComponent graphics;

    /**
     * Constructor for creating a TreeOrgan object
     * 
     * @param parentOrgan Tree organ from which this component grows
     */
    public BranchComponent(TreeOrgan parentOrgan) {
        this.parentOrgan = parentOrgan;
        this.random = Simulation.random;
    }

    /**
     * Returns the organ from which this component grows
     * 
     * @return The parent tree organ
     */
    public TreeOrgan getParentOrgan() {
        return parentOrgan;
    }
}