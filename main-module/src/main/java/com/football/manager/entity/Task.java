package com.football.manager.entity;

import java.util.Objects;

public class Task {

    private Integer id;
    private int sessionId;
    private int roundId;
    private int competitionId;
    private String type;
    private int parserId;
    private int eventId;

    public Task() {
    }

    public Task(int sessionId, int roundId, int competitionId, int eventId) {
        this.sessionId = sessionId;
        this.roundId = roundId;
        this.competitionId = competitionId;
        this.eventId = eventId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getParserId() {
        return parserId;
    }

    public void setParserId(int parserId) {
        this.parserId = parserId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id &&
                sessionId == task.sessionId &&
                roundId == task.roundId &&
                competitionId == task.competitionId &&
                parserId == task.parserId &&
                eventId == task.eventId &&
                Objects.equals(type, task.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sessionId, roundId, competitionId, type, parserId, eventId);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", sessionId=" + sessionId +
                ", roundId=" + roundId +
                ", competitionId=" + competitionId +
                ", type='" + type + '\'' +
                ", parserId=" + parserId +
                ", eventId=" + eventId +
                '}';
    }

}