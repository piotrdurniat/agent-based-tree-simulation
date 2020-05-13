package simulation.tree.tree_organ.branch_component.subcomponents;

import simulation.tree.tree_organ.branch_component.Branch;

public class Flower extends BranchSubcomponent {
    public Flower(Branch parentBranch) {
        super(parentBranch);

        graphics = new FlowerGraphics(this);
    }

    @Override
    public void evaluateTurn() {

    }
}