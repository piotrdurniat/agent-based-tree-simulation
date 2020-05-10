package simulation.tree.tree_organ.branch_component.subcomponents;

import simulation.tree.tree_organ.branch_component.Branch;

public class Leaf extends BranchSubcomponent {
    public Leaf(Branch parentBranch) {
        super(parentBranch);

        graphics = new LeafGraphics(this);
    }

    @Override
    public void evaluateTurn() {

    }

}