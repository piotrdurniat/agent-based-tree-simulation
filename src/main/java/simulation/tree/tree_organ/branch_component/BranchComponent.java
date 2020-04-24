package simulation.tree.tree_organ.branch_component;

import simulation.tree.tree_organ.TreeOrgan;

public abstract class BranchComponent extends TreeOrgan {

    private TreeOrgan parentOrgan;

    /**
     * Constructor for creating TreeOrgan objects
     * 
     * @param parentOrgan Tree organ from which this component grows
     */
    public BranchComponent(TreeOrgan parentOrgan) {
        this.parentOrgan = parentOrgan;
    }

    /**
     * @return TreeOrgan Returns parent tree organ
     */
    public TreeOrgan getParentOrgan() {
        return parentOrgan;
    }

}