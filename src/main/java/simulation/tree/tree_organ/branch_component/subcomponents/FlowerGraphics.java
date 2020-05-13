package simulation.tree.tree_organ.branch_component.subcomponents;

import simulation.graphics.ComponentGraphics;
import simulation.tree.tree_organ.branch_component.Branch;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.util.Random;

class FlowerGraphics extends ComponentGraphics {

    private Flower flower;
    private Random random;

    private float size = 15;
    private float position;
    private int direction;

    /**
     * Constructor for creating FlowerGraphics object
     * 
     * @param flower Flower to draw
     */
    FlowerGraphics(Flower flower) {
        this.flower = flower;
        random = new Random();

        this.position = random.nextFloat();
        this.direction = random.nextInt(2) - 1;
    }

    private float getY() {
        Branch branch = flower.getParentBranch();
        float y = branch.getLength() * position;
        return y;
    }

    /**
     * Draws this flower
     */
    public void show(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(0, 0, 255, 150));

        float y = getY();
        float x = direction * size;

        g2d.fill(new Ellipse2D.Float(x, y, size, size));
    }
}