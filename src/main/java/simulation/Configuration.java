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

    static void loadConfig() {
        try {
            inputStream = new FileInputStream(filePath);
            properties.load(inputStream);

            maxIterations = Integer.parseInt(getProperty("maxIterations"));

        } catch (Exception exception) {
            System.out.println(exception);
        }

    }

    public static String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

}