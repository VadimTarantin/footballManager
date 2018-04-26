package com.football.manager.service.processing.impl;

public abstract class BaseProcessor implements Runnable {

    protected final long TIMEOUT = 120_000L;

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        logInfo("Starting...");
        init();
        logInfo("Started");
        try {
            while (true) {
                doWork();
            }
        } catch (InterruptedException e) {
        }
        long finish = System.currentTimeMillis();
        long delay = (finish - start) / 1000L;
        logInfo("Finished, elapsed time: {} seconds", delay);
    }

    protected void init() {}

    protected abstract void doWork() throws InterruptedException;

    protected abstract void logInfo(String message);

    protected abstract void logInfo(String message, Object p0);

}