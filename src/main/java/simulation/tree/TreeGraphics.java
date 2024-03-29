package simulation.tree;

import simulation.graphics.IGraphicalComponent;

import java.awt.Graphics;

class TreeGraphics implements IGraphicalComponent {

    private Tree tree;

    /**
     * Constuctor for creating a TreeGraphics object
     * 
     * @param tree Tree object to draw
     */
    TreeGraphics(Tree tree) {
        this.tree = tree;
    }

    /**
     * Draws the tree and invokes draw method on it's organs
     */
    public void show(Graphics g) {
        IGraphicalComponent trunk = (IGraphicalComponent) tree.getTrunk();

        g.translate(0, -20);
        trunk.show(g);
    }

}