package com.football.manager.dto.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class InputDataForTaskFromForm {

    private static final String ERROR_MESSAGE = "Поле не может быть пустым";

    @NotNull(message = ERROR_MESSAGE)
    private Integer sessionId;
    @NotNull(message = ERROR_MESSAGE)
    private Integer roundId;
    @NotNull(message = ERROR_MESSAGE)
    private Integer competitionId;
    @NotBlank(message = ERROR_MESSAGE)
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

    @Override
    public String toString() {
        return "InputDataForTaskFromForm{" +
                "sessionId=" + sessionId +
                ", roundId=" + roundId +
                ", competitionId=" + competitionId +
                ", eventName='" + eventName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputDataForTaskFromForm that = (InputDataForTaskFromForm) o;
        return Objects.equals(sessionId, that.sessionId) &&
                Objects.equals(roundId, that.roundId) &&
                Objects.equals(competitionId, that.competitionId) &&
                Objects.equals(eventName, that.eventName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sessionId, roundId, competitionId, eventName);
    }

}