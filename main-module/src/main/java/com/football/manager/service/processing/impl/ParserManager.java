package com.football.manager.service.processing.impl;

import com.football.manager.entity.OverUnderTableTeam;
import com.football.manager.entity.TableTeam;

import java.util.concurrent.ArrayBlockingQueue;

public class ParserManager implements Runnable {

    private ArrayBlockingQueue<String> wideAndFormResponse;
    private ArrayBlockingQueue<String> overUnderResponse;

    private ArrayBlockingQueue<TableTeam> wideAndFormTableTeams;
    private ArrayBlockingQueue<OverUnderTableTeam> overUnderTableTeams;

    public ParserManager(ArrayBlockingQueue<String> wideAndFormResponse,
                         ArrayBlockingQueue<String> overUnderResponse,
                         ArrayBlockingQueue<TableTeam> wideAndFormTableTeams,
                         ArrayBlockingQueue<OverUnderTableTeam> overUnderTableTeams) {
        this.wideAndFormResponse = wideAndFormResponse;
        this.overUnderResponse = overUnderResponse;
        this.wideAndFormTableTeams = wideAndFormTableTeams;
        this.overUnderTableTeams = overUnderTableTeams;
    }

    @Override
    public void run() {
        //wideAndFormResponse -> wideAndFormTableTeams
        //overUnderResponse -> overUnderTableTeams
    }

}