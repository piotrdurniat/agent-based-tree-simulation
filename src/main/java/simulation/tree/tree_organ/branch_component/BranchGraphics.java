package simulation.tree.tree_organ.branch_component;

import simulation.graphics.IGraphicalComponent;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;

import java.lang.Math;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.awt.BasicStroke;

class BranchGraphics implements IGraphicalComponent {

    Branch branch;

    /**
     * Constructor for creating a BranchGraphics object
     * 
     * @param branch Branch to draw
     */
    BranchGraphics(Branch branch) {
        this.branch = branch;
    }

    /**
     * Returns the branch end point relative to (0, 0)
     * 
     * @return The branch end point
     */
    Point2D.Float getEnd() {
        float angle = branch.getAngle();
        float length = branch.getLength();
        float x = (float) (length * Math.sin(angle));
        float y = (float) (-length * Math.cos(angle));

        return new Point2D.Float(x, y);
    }

    /**
     * Draws this branch and invokes draw method on all subcomponents
     */
    public void show(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(new Color(255, 255, 255, 150));
        g2d.setStroke(new BasicStroke(branch.getDiameter(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

        Point2D end = getEnd();

        float endX = (float) end.getX();
        float endY = (float) end.getY();

        List<BranchComponent> components = branch.getComponents();

        float angle = branch.getAngle();

        g2d.draw(new Line2D.Float(0f, 0f, endX, endY));

        g2d.translate(endX, endY);
        g2d.rotate(angle);

        for (BranchComponent component : new ArrayList<BranchComponent>(components)) {
            component.show(g);
        }

        g2d.rotate(-angle);
        g2d.translate(-endX, -endY);

    }
}