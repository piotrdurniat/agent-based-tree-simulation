package simulation.tree.tree_organ.branch_component;

import java.util.Random;

import simulation.Simulation;
import simulation.tree.tree_organ.TreeOrgan;

public abstract class BranchComponent extends TreeOrgan {

    private TreeOrgan parentOrgan;
    protected Random random;

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
     * @return TreeOrgan Returns parent tree organ
     */
    public TreeOrgan getParentOrgan() {
        return parentOrgan;
    }

}