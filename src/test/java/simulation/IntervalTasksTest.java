package simulation;

import static org.junit.Assert.assertTrue;

import java.util.Timer;

import org.junit.Test;

import simulation.tree.Tree;

public class IntervalTasksTest {

    @Test
    public void setupTest() {

        Tree tree = new Tree();

        IntervalTasks.setup(tree);
        assertTrue("timer test", IntervalTasks.timer instanceof Timer);
    }

}