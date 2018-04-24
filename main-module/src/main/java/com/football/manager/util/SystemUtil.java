package com.football.manager.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Closeable;
import java.io.IOException;

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
        } catch (IOException e) {
            log.warn("Error during closing resource: {}", resource);
        }
    }

}
