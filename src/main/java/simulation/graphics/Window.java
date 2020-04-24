package simulation.graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;

import simulation.tree.Tree;

public class Window extends JPanel {
    private static final long serialVersionUID = -2966851797176229831L;

    private static JFrame frame;
    private static Tree tree;
    private static Window panel;

    /**
     * Constructor for creating graphical window to visualize the simulation
     * 
     * @param tree Simulation's tree to draw to the window
     */
    public static void setup(Tree tree) {

        Window.tree = tree;

        SwingUtilities.invokeLater(() -> {
            panel = new Window();
            panel.setBackground(new Color(51, 51, 51));

            frame = new JFrame("Tree simulation");
            frame.setSize(800, 800);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(panel, BorderLayout.CENTER);
            frame.setLocationRelativeTo(null); // Causes the window to appear in the center of the screen
            frame.setVisible(true);
        });
    }

    /**
     * Refreshes the window to show all changes
     */
    public static void redraw() {
        panel.repaint();
    }

    /**
     * Invoked by the runtime system when the panel needs to be drawn
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.translate(frame.getWidth() / 2, frame.getHeight());
        tree.getGraphics().show(g);
    }
}