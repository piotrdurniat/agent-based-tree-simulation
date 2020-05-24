package simulation;

public class Environment {

    private static float light = Configuration.environmentLight;
    private static float environmentC02 = Configuration.environmentC02;
    private static float environmentWater = Configuration.environmentWater;

    public float getLight() {
        return light;
    }

    public float getCarbonDioxide() {
        return environmentC02;
    }

    public float getWater() {
        return environmentWater;
    }
}