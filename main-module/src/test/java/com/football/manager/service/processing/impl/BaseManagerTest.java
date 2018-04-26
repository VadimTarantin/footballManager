package com.football.manager.service.processing.impl;

import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public abstract class BaseManagerTest {

    protected static final org.apache.logging.log4j.Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

}