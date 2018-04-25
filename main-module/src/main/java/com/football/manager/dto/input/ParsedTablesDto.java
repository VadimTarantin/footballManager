package com.football.manager.dto.input;

import com.football.manager.entity.OverUnderTableTeam;
import com.football.manager.entity.TableTeam;

import java.util.Objects;

public class ParsedTablesDto {

    private TableTeam wideTableTeam;
    private TableTeam formTableTeam;
    private OverUnderTableTeam overUnderTableTeam;

    public ParsedTablesDto(TableTeam wideTableTeam, TableTeam formTableTeam, OverUnderTableTeam overUnderTableTeam) {
        this.wideTableTeam = wideTableTeam;
        this.formTableTeam = formTableTeam;
        this.overUnderTableTeam = overUnderTableTeam;
    }

    public TableTeam getWideTableTeam() {
        return wideTableTeam;
    }

    public TableTeam getFormTableTeam() {
        return formTableTeam;
    }

    public OverUnderTableTeam getOverUnderTableTeam() {
        return overUnderTableTeam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParsedTablesDto that = (ParsedTablesDto) o;
        return Objects.equals(wideTableTeam, that.wideTableTeam) &&
                Objects.equals(formTableTeam, that.formTableTeam) &&
                Objects.equals(overUnderTableTeam, that.overUnderTableTeam);
    }

    @Override
    public int hashCode() {

        return Objects.hash(wideTableTeam, formTableTeam, overUnderTableTeam);
    }

    @Override
    public String toString() {
        return "ParsedTablesDto{" +
                "wideTableTeam=" + wideTableTeam +
                ", formTableTeam=" + formTableTeam +
                ", overUnderTableTeam=" + overUnderTableTeam +
                '}';
    }

}