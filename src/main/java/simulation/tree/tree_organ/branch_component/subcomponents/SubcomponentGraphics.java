package simulation.tree.tree_organ.branch_component.subcomponents;

import simulation.graphics.ComponentGraphics;
import simulation.tree.tree_organ.branch_component.Branch;

import java.util.Random;

public abstract class SubcomponentGraphics extends ComponentGraphics {
    private Random random;

    private float position;
    private BranchSubcomponent component;
    protected int direction;

    /**
     * Constructor for creating SubcomponentGraphics object
     * 
     * @param component BranchComponent The object to draw
     */
    SubcomponentGraphics(BranchSubcomponent component) {
        this.component = component;
        random = new Random();

        this.position = random.nextFloat();
        this.direction = random.nextInt(2) - 1;
    }

    /**
     * @return float Returns vertical position of this component relative to the end
     *         of the branch
     */
    protected float getY() {
        Branch branch = component.getParentBranch();
        float y = branch.getLength() * position;
        return y;
    }

}