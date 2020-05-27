package simulation.graphics;

import java.awt.Graphics;

public interface IGraphicalComponent {

    /**
     * Method for drawing the object on the window
     * 
     * @param g Graphics object used for drawing
     */
    public void show(Graphics g);
}