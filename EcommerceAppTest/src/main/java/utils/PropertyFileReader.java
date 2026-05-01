package utils;

import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
    private static Properties properties;

    static {
        try {
            properties = new Properties();

            InputStream input = PropertyFileReader.class.getClassLoader().getResourceAsStream("config.properties");

            if (input == null) {
                throw new RuntimeException("Cannot find config.properties in the resources folder!");
            }

            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file.");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}