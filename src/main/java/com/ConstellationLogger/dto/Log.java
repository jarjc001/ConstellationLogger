package com.ConstellationLogger.dto;

import java.time.LocalDate;
import java.util.List;

public class Log {

    private int logId;
    private LocalDate logDate;
    private User user;

    private List<Constellation> constellationList;
    private String extraInfo;

    private String locationName;
    private double lat;


    public Log(int logId, LocalDate logDate, User user, int locationId, List<Constellation> constellationList, String extraInfo, String locationName, double lat) {
        this.logId = logId;
        this.logDate = logDate;
        this.user = user;
        this.constellationList = constellationList;
        this.extraInfo = extraInfo;
        this.locationName = locationName;
        this.lat = lat;
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
    public User getUser() {
        return user;
    }

    public List<Constellation> getConstellationList() {
        return constellationList;
    }
    public String getExtraInfo() {
        return extraInfo;
    }
    public String getLocationName() {
        return locationName;
    }
    public double getLat() {
        return lat;
    }
    //setters

    public void setLogId(int logId) {
        this.logId = logId;
    }
    public void setLogDate(LocalDate logDate) {
        this.logDate = logDate;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public void setConstellationList(List<Constellation> constellationList) {
        this.constellationList = constellationList;
    }
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", logDate=" + logDate +
                ", username='" + user + '\'' +
                ", constellationList=" + constellationList +
                ", extraInfo='" + extraInfo + '\'' +
                ", locationName='" + locationName + '\'' +
                ", lat=" + lat +
                '}';
    }
}
