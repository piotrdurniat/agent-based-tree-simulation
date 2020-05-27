package simulation;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private static Properties properties = new Properties();
    private static String filePath = "src/simulation.config";
    private static InputStream inputStream;

    // Properties related to simulation:
    public static int maxIterations;

    // Properties related to environment:
    public static float environmentLight;
    public static float environmentCO2;
    public static float environmentWater;

    // Properties related to branch:
    public static float newBranchProbability;
    public static float newLeafProbability;
    public static float newFlowerProbability;
    public static float glucosePerBranch;
    public static int branchingFactor;
    public static float angleBetweenBranches;
    public static float branchGrowthSpeed;

    // Properties related to leaf:
    public static float leafMinLight;
    public static float maxLeafLength;
    public static float leafGrowthSpeed;

    // Properties related to flower:
    public static float glucosePerFlower;
    public static float flowerMinLight;
    public static float flowerMaxDiameter;
    public static float flowerGrowthSpeed;

    // Properties related to fruit:
    public static float glucosePerFruit;
    public static float fruitRipeningSpeed;
    public static float fruitSize;

    // Properties related to rootSystem
    public static float rootSystemGrowthSpeed;

    /**
     * Reads configuration file and parses property values to variables
     */
    static void loadConfig() {
        try {
            inputStream = new FileInputStream(filePath);
            properties.load(inputStream);

            maxIterations = Integer.parseInt(getProperty("maxIterations"));

            environmentLight = Float.parseFloat(getProperty("environmentLight"));
            environmentCO2 = Float.parseFloat(getProperty("environmentCO2"));
            environmentWater = Float.parseFloat(getProperty("environmentWater"));

            newBranchProbability = Float.parseFloat(getProperty("newBranchProbability"));
            newLeafProbability = Float.parseFloat(getProperty("newLeafProbability"));
            newFlowerProbability = Float.parseFloat(getProperty("newFlowerProbability"));
            glucosePerBranch = Float.parseFloat(getProperty("glucosePerBranch"));
            branchingFactor = Integer.parseInt(getProperty("branchingFactor"));
            angleBetweenBranches = Float.parseFloat(getProperty("angleBetweenBranches"));
            branchGrowthSpeed = Float.parseFloat(getProperty("branchGrowthSpeed"));

            maxLeafLength = Float.parseFloat(getProperty("maxLeafLength"));
            leafGrowthSpeed = Float.parseFloat(getProperty("leafGrowthSpeed"));
            leafMinLight = Float.parseFloat(getProperty("leafMinLight"));

            glucosePerFlower = Float.parseFloat(getProperty("glucosePerFlower"));
            flowerMinLight = Float.parseFloat(getProperty("flowerMinLight"));
            flowerMaxDiameter = Float.parseFloat(getProperty("flowerMaxDiameter"));
            flowerGrowthSpeed = Float.parseFloat(getProperty("flowerGrowthSpeed"));

            glucosePerFruit = Float.parseFloat(getProperty("glucosePerFruit"));
            fruitRipeningSpeed = Float.parseFloat(getProperty("fruitRipeningSpeed"));
            fruitSize = Float.parseFloat(getProperty("fruitSize"));

            rootSystemGrowthSpeed = Float.parseFloat(getProperty("rootSystemGrowthSpeed"));

        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    /**
     * Returns property from configuration file with given name
     * 
     * @param propertyName Name of the property
     * @return String The string value of property with given name
     */
    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

}