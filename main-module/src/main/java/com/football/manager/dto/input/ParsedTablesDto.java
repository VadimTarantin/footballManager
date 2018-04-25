package com.football.manager.dto.input;

import com.football.manager.entity.OverUnderTableTeam;
import com.football.manager.entity.TableTeam;

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
}