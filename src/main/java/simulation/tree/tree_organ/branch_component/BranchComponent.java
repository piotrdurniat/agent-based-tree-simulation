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
     * Constructor for creating TreeOrgan objects
     * 
     * @param parentOrgan Tree organ from which this component grows
     */
    public BranchComponent(TreeOrgan parentOrgan) {
        this.parentOrgan = parentOrgan;
        this.random = Simulation.random;
    }

    /**
     * @return The parent tree organ
     */
    public TreeOrgan getParentOrgan() {
        return parentOrgan;
    }
}