package com.football.manager.util;

import org.junit.Assert;
import org.junit.Test;

public class SystemUtilTest {

    @Test
    public void testGetCurrentClass() {
        SystemUtilTest.testGetCurrentClassFromStaticContext();
    }

    private static void testGetCurrentClassFromStaticContext() {
        String currentClass = SystemUtil.getCurrentClass();
        Assert.assertEquals(SystemUtilTest.class.getName(), currentClass);
    }

}
