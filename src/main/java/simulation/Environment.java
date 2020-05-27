package simulation;

public class Environment {

    private static float light = Configuration.environmentLight;
    private static float environmentCO2 = Configuration.environmentCO2;
    private static float environmentWater = Configuration.environmentWater;

    /**
     * Returns the configured amount of light
     * 
     * @return The amount of light
     */
    public float getLight() {
        return light;
    }

    /**
     * Returns the configured amount of CO2
     * 
     * @return The amount of CO2
     */
    public float getCarbonDioxide() {
        return environmentCO2;
    }

    /**
     * Returns the configured amount of water
     * 
     * @return The amount of water
     */
    public float getWater() {
        return environmentWater;
    }
}