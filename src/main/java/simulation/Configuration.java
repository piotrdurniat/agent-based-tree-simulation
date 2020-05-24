package simulation;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private static Properties properties = new Properties();
    private static String filePath = "src/simulation.config";
    private static InputStream inputStream;

    public static int maxIterations;
    public static float leafMinLight;

    public static float environmentLight;
    public static float environmentCO2;
    public static float environmentWater;

    public static float newBranchProbability;
    public static float newLeafProbability;
    public static float newFlowerProbability;

    public static float glucosePerBranch;

    public static int branchingFactor;
    public static float angleBetweenBranches;

    public static float maxLeafLength;

    static void loadConfig() {
        try {
            inputStream = new FileInputStream(filePath);
            properties.load(inputStream);

            maxIterations = Integer.parseInt(getProperty("maxIterations"));
            leafMinLight = Float.parseFloat(getProperty("leafMinLight"));

            environmentLight = Float.parseFloat(getProperty("environmentLight"));
            environmentCO2 = Float.parseFloat(getProperty("environmentCO2"));
            environmentWater = Float.parseFloat(getProperty("environmentWater"));

            newBranchProbability = Float.parseFloat(getProperty("newBranchProbability"));
            newLeafProbability = Float.parseFloat(getProperty("newLeafProbability"));
            newFlowerProbability = Float.parseFloat(getProperty("newFlowerProbability"));

            glucosePerBranch = Float.parseFloat(getProperty("glucosePerBranch"));

            branchingFactor = Integer.parseInt(getProperty("branchingFactor"));
            angleBetweenBranches = Float.parseFloat(getProperty("angleBetweenBranches"));

            maxLeafLength = Float.parseFloat(getProperty("maxLeafLength"));

        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

}