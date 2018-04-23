package com.football.manager.dto.input;

import javax.validation.constraints.NotNull;

public class InputDataForTaskFromForm {

    private static final String ERROR_MESSAGE = "Поле не может быть пустым";

    @NotNull(message = ERROR_MESSAGE)
    private Integer sessionId;
    @NotNull(message = ERROR_MESSAGE)
    private Integer roundId;
    @NotNull(message = ERROR_MESSAGE)
    private Integer competitionId;
    @NotNull(message = ERROR_MESSAGE)
    private String eventName;

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public Integer getRoundId() {
        return roundId;
    }

    public void setRoundId(Integer roundId) {
        this.roundId = roundId;
    }

    public Integer getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(Integer competitionId) {
        this.competitionId = competitionId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

}