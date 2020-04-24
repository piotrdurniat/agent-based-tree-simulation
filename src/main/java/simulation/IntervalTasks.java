package simulation;

import simulation.tree.Tree;

import java.util.TimerTask;
import java.util.Timer;
import simulation.graphics.Window;

public class IntervalTasks extends TimerTask {

    public static int turnNum;
    public static Tree tree;

    /**
     * @param tree Tree object passed to evaluate it's turns on every interval
     */
    public static void setup(Tree tree) {

        IntervalTasks.tree = tree;

        Timer timer = new Timer();
        TimerTask task = new IntervalTasks();
        timer.schedule(task, 2000, 16);
    }

    /**
     * Interval function invoked after the set amount of time
     */
    public void run() {

        tree.evaluateTurn();
        Window.redraw();

        turnNum++;
    }

}