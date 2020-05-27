package simulation;

import simulation.tree.Tree;

import java.util.TimerTask;
import java.util.Timer;
import simulation.graphics.Window;

public class IntervalTasks extends TimerTask {

    public static int turnNum;
    public static Tree tree;
    public static Timer timer;

    /**
     * Sets up the timer to invoke a method at regular intervals
     * 
     * @param tree Tree object passed to evaluate it's turns on every interval
     */
    public static void setup(Tree tree) {
        IntervalTasks.tree = tree;
        timer = new Timer();
        TimerTask task = new IntervalTasks();
        timer.schedule(task, 200, 16);
    }

    /**
     * Method which is invoked at regular intervals
     */
    public void run() {
        if (turnNum >= Configuration.maxIterations) {
            timer.cancel();
        }

        tree.evaluateTurn();
        Window.redraw();

        turnNum++;
    }

}