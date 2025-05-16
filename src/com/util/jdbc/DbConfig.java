package com.util.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.util.customexception.ExceptionMessages;
import com.util.customexception.TaskException;

public final class DbConfig {

    private static final String CONFIG_PATH = "./config/db.properties";
    private static volatile Properties properties = null;
    private static final Object lock = new Object();

    private DbConfig() {
        // Prevent instantiation
    }

    private static void loadProperties() throws TaskException {
        if (properties != null) return;

        synchronized (lock) {
            if (properties != null) return;

            Properties tempProps = new Properties();
            try (FileInputStream fis = new FileInputStream(CONFIG_PATH)) {
                tempProps.load(fis);
                properties = tempProps;
            } 
            		catch (IOException e) {
                throw new TaskException(
                    ExceptionMessages.DB_CREDENTIALS_NOT_FOUND + CONFIG_PATH, e);
            }
        }
    }

    public static String getDbUrl() throws TaskException {
        loadProperties();
        return get("db.url");
    }

    public static String getDbUser() throws TaskException {
        loadProperties();
        return get("db.user");
    }

    public static String getDbPassword() throws TaskException {
        loadProperties();
        return get("db.password");
    }

    private static String get(String key) throws TaskException {
        String value = properties.getProperty(key);
        if (value == null || value.isEmpty()) {
            throw new TaskException(ExceptionMessages.DB_KEY_MISSING);
        }
        return value;
    }
}