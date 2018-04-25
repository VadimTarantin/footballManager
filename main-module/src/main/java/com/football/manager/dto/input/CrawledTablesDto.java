package com.football.manager.dto.input;

public class CrawledTablesDto {

    private String wideTableResponse;
    private String formTableResponse;
    private String overUnderTableResponse;

    public CrawledTablesDto(String wideTableResponse, String formTableResponse, String overUnderTableResponse) {
        this.wideTableResponse = wideTableResponse;
        this.formTableResponse = formTableResponse;
        this.overUnderTableResponse = overUnderTableResponse;
    }

    public String getWideTableResponse() {
        return wideTableResponse;
    }

    public String getFormTableResponse() {
        return formTableResponse;
    }

    public String getOverUnderTableResponse() {
        return overUnderTableResponse;
    }

}