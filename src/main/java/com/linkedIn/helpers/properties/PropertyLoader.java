package com.linkedIn.helpers.properties;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import static com.linkedIn.helpers.properties.PropertySource.EMAIL;
import static com.linkedIn.helpers.properties.PropertySource.PASSWORD;

public class PropertyLoader {
    private static Properties prop = new Properties();


    private static Properties preloadProperties(PropertySource source) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceStream = loader.getResourceAsStream(source.sourceFile)) {
            Properties properties = new Properties();
            properties.load(resourceStream);
            prop.put(source, properties);
            return properties;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidPropertiesFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String loadUserEmailProperty(String propertyName) {
        Properties properties = (Properties) prop.get(EMAIL);
        if (properties == null)
            properties = preloadProperties(EMAIL);
        String property = properties.getProperty(propertyName);
        if (property == null) {
            return "No property file found";
        } else {
            return property;
        }
    }

    public static String loadUserPasswordProperty(String propertyName) {
        Properties properties = (Properties) prop.get(PASSWORD);
        if (properties == null)
            properties = preloadProperties(PASSWORD);
        String property = properties.getProperty(propertyName);
        if (property == null) {
            return "No property file found";
        } else {
            return property;
        }
    }
}
