package simulation.tree.tree_organ.branch_component.subcomponents;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

class FlowerGraphics extends SubcomponentGraphics {

    private Flower flower;

    /**
     * Constructor for creating FlowerGraphics object
     * 
     * @param flower Flower object to draw
     */
    FlowerGraphics(Flower flower) {
        super(flower);
        this.flower = flower;
    }

    /**
     * Draws this flower
     */
    public void show(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(0, 0, 255, 150));

        float diameter = flower.getDiameter();
        float y = getY();
        float x = direction * diameter;

        g2d.fill(new Ellipse2D.Float(x, y, diameter, diameter));
    }
}