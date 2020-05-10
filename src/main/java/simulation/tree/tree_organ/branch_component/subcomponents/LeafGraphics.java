package simulation.tree.tree_organ.branch_component.subcomponents;

import simulation.graphics.ComponentGraphics;
import simulation.tree.tree_organ.branch_component.Branch;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.util.Random;

class LeafGraphics extends ComponentGraphics {

    private Leaf leaf;
    private Random random;

    private float length = 10;
    private float position;
    private int direction;

    /**
     * Constructor for creating LeafGraphics object
     * 
     * @param leaf Leaf to draw
     */
    LeafGraphics(Leaf leaf) {
        this.leaf = leaf;
        random = new Random();

        this.position = random.nextFloat();
        this.direction = random.nextInt(2) - 1;
    }

    private float getY() {
        Branch branch = leaf.getParentBranch();
        float y = branch.getLength() * position;
        return y;
    }

    /**
     * Draws this leaf
     */
    public void show(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(0, 255, 0, 150));

        float y = getY();
        float x = direction * length;

        g2d.fill(new Ellipse2D.Float(x, y, length, length / 2));
    }
}