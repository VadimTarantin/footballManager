package com.football.manager.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Closeable;
import java.sql.Connection;

public class SystemUtil {

    private static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    public static String getCurrentClass() {
        try {
            throw new Exception();
        } catch (Exception e) {
            return e.getStackTrace()[1].getClassName();
        }
    }

    public static void closeQuietly(Closeable resource) {
        try {
            if (resource != null) {
                resource.close();
            }
        } catch (Exception e) {
            log.warn("Error during closing resource: {}", resource);
        }
    }

    public static void closeQuietlyConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (Exception e) {
            log.warn("Error during closing connection: {}", connection);
        }
    }

}
