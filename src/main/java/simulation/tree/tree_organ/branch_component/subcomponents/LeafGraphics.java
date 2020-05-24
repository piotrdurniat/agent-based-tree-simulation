package simulation.tree.tree_organ.branch_component.subcomponents;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

class LeafGraphics extends SubcomponentGraphics {

    Leaf leaf;

    /**
     * Constructor for creating LeafGraphics object
     * 
     * @param leaf Leaf to draw
     */
    LeafGraphics(Leaf leaf) {
        super(leaf);
        this.leaf = leaf;
    }

    /**
     * Draws this leaf
     */
    public void show(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(0, 255, 0, 150));

        float length = leaf.getLength();
        float y = getY();
        float x = direction * length;

        g2d.fill(new Ellipse2D.Float(x, y, length, length / 2));
    }
}