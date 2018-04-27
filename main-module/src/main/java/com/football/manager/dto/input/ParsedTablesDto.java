package com.football.manager.dto.input;

import com.football.manager.entity.OverUnderTableTeam;
import com.football.manager.entity.TableTeam;

import java.util.List;
import java.util.Objects;

public class ParsedTablesDto {

    private List<? extends TableTeam> wideTableTeams;
    private List<? extends TableTeam> formTableTeams;
    private List<? extends OverUnderTableTeam> overUnderTableTeams;
    private int eventId;

    public ParsedTablesDto(List<? extends TableTeam> wideTableTeam, List<? extends TableTeam> formTableTeams,
                           List<? extends OverUnderTableTeam> overUnderTableTeams, int eventId) {
        this.wideTableTeams = wideTableTeam;
        this.formTableTeams = formTableTeams;
        this.overUnderTableTeams = overUnderTableTeams;
        this.eventId = eventId;
    }

    public List<? extends TableTeam> getWideTableTeams() {
        return wideTableTeams;
    }

    public List<? extends TableTeam> getFormTableTeams() {
        return formTableTeams;
    }

    public List<? extends OverUnderTableTeam> getOverUnderTableTeams() {
        return overUnderTableTeams;
    }

    public int getEventId() {
        return eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParsedTablesDto that = (ParsedTablesDto) o;
        return eventId == that.eventId &&
                Objects.equals(wideTableTeams, that.wideTableTeams) &&
                Objects.equals(formTableTeams, that.formTableTeams) &&
                Objects.equals(overUnderTableTeams, that.overUnderTableTeams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wideTableTeams, formTableTeams, overUnderTableTeams, eventId);
    }

    @Override
    public String toString() {
        return "ParsedTablesDto{" +
                "wideTableTeams=" + wideTableTeams +
                ", formTableTeams=" + formTableTeams +
                ", overUnderTableTeams=" + overUnderTableTeams +
                ", eventId=" + eventId +
                '}';
    }

}