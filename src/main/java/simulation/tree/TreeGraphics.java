package simulation.tree;

import simulation.graphics.ComponentGraphics;
import simulation.tree.tree_organ.TreeOrgan;

import java.awt.Graphics;
import java.util.ArrayList;

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

        ArrayList<TreeOrgan> organs = tree.getTreeOrgans();

        for (TreeOrgan organ : organs) {
            organ.getGraphics().show(g);
        }
    }
}