package simulation.tree.tree_organ.branch_component.subcomponents;

import simulation.tree.tree_organ.branch_component.Branch;
import simulation.tree.tree_organ.branch_component.BranchComponent;

public abstract class BranchSubcomponent extends BranchComponent {
    Branch parentBranch;

    public BranchSubcomponent(Branch parentBranch) {
        super(parentBranch);
        this.parentBranch = parentBranch;
    }

    public Branch getParentBranch() {
        return parentBranch;
    }
}