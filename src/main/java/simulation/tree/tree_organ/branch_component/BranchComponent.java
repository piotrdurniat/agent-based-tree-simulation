package simulation.tree.tree_organ.branch_component;

import java.util.Random;

import simulation.Simulation;
import simulation.graphics.ComponentGraphics;
import simulation.graphics.GraphicalComponent;
import simulation.tree.tree_organ.TreeOrgan;

public abstract class BranchComponent extends TreeOrgan implements GraphicalComponent {

    TreeOrgan parentOrgan;
    protected Random random;
    protected ComponentGraphics graphics;

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

    /**
     * @return The graphics object responsible for drawing this tree organ
     */
    public ComponentGraphics getGraphics() {
        return graphics;
    }

}