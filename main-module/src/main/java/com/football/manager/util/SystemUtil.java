package com.football.manager.util;

public class SystemUtil {

    public static String getCurrentClass() {
        try {
            throw new Exception();
        } catch (Exception e) {
            return e.getStackTrace()[1].getClassName();
        }
    }

}
