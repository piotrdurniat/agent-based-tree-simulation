package simulation.tree.tree_organ.branch_component.subcomponents;

import simulation.tree.tree_organ.branch_component.Branch;

public class Fruit extends BranchSubcomponent {
    public Fruit(Branch parentBranch) {
        super(parentBranch);

        graphics = new FruitGraphics(this);
    }

    @Override
    public void evaluateTurn() {

    }

    public float getWater() {
        return parentBranch.getWater();
    }
}