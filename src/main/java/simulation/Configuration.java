package simulation;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    static private Properties properties = new Properties();
    static private String filePath = "src/simulation.config";
    static private InputStream inputStream;

    public static int maxIterations;
    public static float leafMinLight;

    public static float environmentLight;
    public static float environmentCO2;
    public static float environmentWater;

    public static float newBranchProbability;
    public static float newLeafProbability;
    public static float newFlowerProbability;

    public static float maxBranchLength;
    public static int branchingFactor;

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

            maxBranchLength = Float.parseFloat(getProperty("maxBranchLength"));
            branchingFactor = Integer.parseInt(getProperty("branchingFactor"));

        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

}