package simulation.tree;

import simulation.graphics.ComponentGraphics;
import simulation.graphics.GraphicalComponent;

import java.awt.Graphics;

class TreeGraphics extends ComponentGraphics {

    private Tree tree;

    /**
     * @param tree Tree object to draw
     */
    TreeGraphics(Tree tree) {
        this.tree = tree;
    }

    /**
     * Draws the tree and invokes draw function on it's organs
     */
    public void show(Graphics g) {

        GraphicalComponent trunk = (GraphicalComponent) tree.getTrunk();

        g.translate(0, -20);
        trunk.getGraphics().show(g);

    }
}