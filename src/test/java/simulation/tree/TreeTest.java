package simulation.tree;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import simulation.tree.tree_organ.TreeOrgan;

public class TreeTest {

    private static Tree treeTester = new Tree();

    @Test
    public void getTrunkTest() {
        TreeOrgan trunkTester = treeTester.getTrunk();
        assertTrue("getTrunk test", trunkTester instanceof TreeOrgan);
    }
}