package com.ConstellationLogger.dto;

import java.time.LocalDate;
import java.util.List;

public class Log {

    private int logId;
    private LocalDate logDate;
    private String username;
    private int locationId;
    private List<Constellation> constellationList;
    private String extraInfo;


    public Log(int logId, LocalDate logDate, String username, int location, List<Constellation> constellationList, String extraInfo) {
        this.logId = logId;
        this.logDate = logDate;
        this.username = username;
        this.locationId = location;
        this.constellationList = constellationList;
        this.extraInfo = extraInfo;
    }

    public Log() {
    }

    //getters
    public int getLogId() {
        return logId;
    }
    public LocalDate getLogDate() {
        return logDate;
    }
    public String getUsername() {
        return username;
    }
    public int getLocationId() {
        return locationId;
    }
    public List<Constellation> getConstellationList() {
        return constellationList;
    }
    public String getExtraInfo() {
        return extraInfo;
    }

    //setters

    public void setLogId(int logId) {
        this.logId = logId;
    }
    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    public void setConstellationList(List<Constellation> constellationList) {
        this.constellationList = constellationList;
    }
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }


    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", logDate=" + logDate +
                ", username='" + username + '\'' +
                ", location=" + locationId +
                ", constellationList=" + constellationList +
                ", extraInfo='" + extraInfo + '\'' +
                '}';
    }
}
