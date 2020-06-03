package simulation;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

public class ConfigurationTest {

    @Test
    public void loadConfigTest() {
        try {
            Configuration.loadConfig();
        } catch (Exception exception) {
            fail();
        }
    }

    @Test
    public void getPropertyTest() {

        loadConfigTest();

        String maxInterations = Configuration.getProperty("maxIterations");
        assertTrue("getProperty test", maxInterations instanceof String);
    }
}