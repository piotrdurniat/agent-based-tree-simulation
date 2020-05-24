package simulation;

public class Environment {

    private static float light = Configuration.environmentLight;
    private static float environmentCO2 = Configuration.environmentCO2;
    private static float environmentWater = Configuration.environmentWater;

    public float getLight() {
        return light;
    }

    public float getCarbonDioxide() {
        return environmentCO2;
    }

    public float getWater() {
        return environmentWater;
    }
}