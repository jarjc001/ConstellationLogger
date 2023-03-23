package com.ConstellationLogger.dto;

import java.time.LocalDate;
import java.util.List;

public class Log {

    private int logId;
    private LocalDate logDate;
    private User user;

    private List<Constellation> constellationList;
    private String extraInfo;

    private double logLat;


    public Log(int logId, LocalDate logDate, User user, List<Constellation> constellationList, String extraInfo, double logLat) {
        this.logId = logId;
        this.logDate = logDate;
        this.user = user;
        this.constellationList = constellationList;
        this.extraInfo = extraInfo;
        this.logLat = logLat;
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
    public double getLogLat() {
        return logLat;
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
    public void setLogLat(double logLat) {
        this.logLat = logLat;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", logDate=" + logDate +
                ", username='" + user + '\'' +
                ", constellationList=" + constellationList + '\'' +
                ", lat=" + logLat +
                ", extraInfo='" + extraInfo +
                '}';
    }
}
