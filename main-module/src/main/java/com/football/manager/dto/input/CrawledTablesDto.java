package com.football.manager.dto.input;

import java.util.Objects;

public class CrawledTablesDto {

    private String wideTableResponse;
    private String formTableResponse;
    private String overUnderTableResponse;
    private int eventId;

    public CrawledTablesDto(String wideTableResponse, String formTableResponse, String overUnderTableResponse, int eventId) {
        this.wideTableResponse = wideTableResponse;
        this.formTableResponse = formTableResponse;
        this.overUnderTableResponse = overUnderTableResponse;
        this.eventId = eventId;
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

    public int getEventId() {
        return eventId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrawledTablesDto that = (CrawledTablesDto) o;
        return eventId == that.eventId &&
                Objects.equals(wideTableResponse, that.wideTableResponse) &&
                Objects.equals(formTableResponse, that.formTableResponse) &&
                Objects.equals(overUnderTableResponse, that.overUnderTableResponse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wideTableResponse, formTableResponse, overUnderTableResponse, eventId);
    }

    @Override
    public String toString() {
        return "CrawledTablesDto{" +
                "wideTableResponse='" + wideTableResponse + '\'' +
                ", formTableResponse='" + formTableResponse + '\'' +
                ", overUnderTableResponse='" + overUnderTableResponse + '\'' +
                ", eventId=" + eventId +
                '}';
    }

}