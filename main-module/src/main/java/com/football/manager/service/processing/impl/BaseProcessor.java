package com.football.manager.service.processing.impl;

import com.football.manager.util.SystemUtil;

public abstract class BaseProcessor implements Runnable {

    protected final long TIMEOUT = 120_000L;

    @Override
    public void run() {
        String currentClass = SystemUtil.getCurrentClass();
        long start = System.currentTimeMillis();
        logInfo("{} starting", currentClass);
        init();
        logInfo("{} started", currentClass);
        try {
            while (true) {
                doWork();
            }
        } catch (InterruptedException e) {
        }
        long finish = System.currentTimeMillis();
        long delay = (finish - start) / 1000L;
        logInfo("{} has finished, elapsed time: {} seconds", currentClass, delay);
    }

    protected void init() {}

    protected abstract void doWork() throws InterruptedException;

    protected abstract void logInfo(String message, Object p0);

    protected abstract void logInfo(String message, Object p0, Object p1);

}