package simulation;

import simulation.tree.Tree;

import java.util.TimerTask;
import java.util.Timer;
import simulation.graphics.Window;

public class IntervalTasks extends TimerTask {

    public static int turnNum;
    public static Tree tree;
    public static Timer timer;
    public static int maxIterations;

    /**
     * @param tree Tree object passed to evaluate it's turns on every interval
     */
    public static void setup(Tree tree, int maxIterations) {

        IntervalTasks.tree = tree;
        IntervalTasks.maxIterations = maxIterations;

        timer = new Timer();
        TimerTask task = new IntervalTasks();
        timer.schedule(task, 200, 16);
    }

    /**
     * Interval function invoked after the set amount of time
     */
    public void run() {
        if (turnNum >= maxIterations) {
            timer.cancel();
        }

        tree.evaluateTurn();
        Window.redraw();

        turnNum++;
    }

}