package simulation.tree.tree_organ.branch_component.subcomponents;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import simulation.Configuration;

import java.awt.Color;

public class FruitGraphics extends SubcomponentGraphics {
    private final float size = Configuration.fruitSize;

    private Fruit fruit;

    /**
     * Constructor for creating FlowerGraphics object
     * 
     * @param fruit Fruit object to draw
     */
    FruitGraphics(Fruit fruit) {
        super(fruit);
        this.fruit = fruit;
    }

    /**
     * @return Color value based on ripeness (0 - green 1 - red)
     */
    Color getColor() {
        float ripeness = fruit.getRipeness();
        if (ripeness > 1)
            ripeness = 1;

        float h = (1.0f - ripeness) * 0.25f;
        Color color = Color.getHSBColor(h, 0.6f, 0.7f);
        return color;
    }

    /**
     * Draws this fruit
     */
    public void show(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(getColor());

        float y = getY();
        float x = direction * size;

        g2d.fill(new Ellipse2D.Float(x, y, size, size));
    }
}