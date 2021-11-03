package br.com.softblue.jogoforca.core;

import java.io.IOException;
import java.util.Properties;

public class Config {

    private static final Properties properties = new Properties();

    static {
        try {
            properties.load(Config.class.getResourceAsStream("/config.properties"));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String get(String name) {
        return properties.getProperty(name);
    }

    public static void setMaxErrors(String maxErrors) {
        properties.setProperty("maxErrors", maxErrors);
    }
}
