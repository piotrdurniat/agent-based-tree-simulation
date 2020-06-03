package simulation;

import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.Test;

public class SimulationTest {

    private static Simulation simulationTester = new Simulation();

    @Test
    public void testGetEnvironment() {
        assertTrue("getEnvironment test", simulationTester.getEnvironment() instanceof Environment);
    }

    @Test
    public void testGetTreeOrgans() {
        assertTrue("getTreeOrgans test", simulationTester.getTreeOrgans() instanceof List);
    }
}