package simulation.tree.tree_organ.branch_component.subcomponents;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.Color;

public class FruitGraphics extends SubcomponentGraphics {
    private final float size = 15;

    /**
     * Constructor for creating FlowerGraphics object
     * 
     * @param fruit Fruit object to draw
     */
    FruitGraphics(Fruit fruit) {
        super(fruit);
    }

    /**
     * Draws this fruit
     */
    public void show(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(255, 0, 0, 150));

        float y = getY();
        float x = direction * size;

        g2d.fill(new Ellipse2D.Float(x, y, size, size));
    }
}