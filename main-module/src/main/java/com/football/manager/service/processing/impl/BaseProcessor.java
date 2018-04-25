package com.football.manager.service.processing.impl;

import com.football.manager.util.SystemUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseProcessor implements Runnable {

    protected final long TIMEOUT = 120_000L;
    protected static final Logger log = LogManager.getLogger(SystemUtil.getCurrentClass());

    @Override
    public void run() {
        String currentClass = SystemUtil.getCurrentClass();
        log.info("{} starting", currentClass);
        init();
        log.info("{} started", currentClass);
        try {
            while (true) {
                doWork();
            }
        } catch (InterruptedException e) {
        }
        log.info("{} has finished", currentClass);
    }

    protected void init() {}

    protected abstract void doWork() throws InterruptedException;

}