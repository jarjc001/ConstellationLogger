package com.ConstellationLogger.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Log {

    private int logId;
    @NotBlank(message = "Date must not be empty.")
    private LocalDate logDate;

    @NotBlank(message = "User must not be empty.")
    private User user;

    private List<Constellation> constellationList;
    private String extraInfo;

    @NotBlank(message = "Latitude must not be empty.")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return logId == log.logId && Double.compare(log.logLat, logLat) == 0 && Objects.equals(logDate, log.logDate) && Objects.equals(user, log.user) && Objects.equals(constellationList, log.constellationList) && Objects.equals(extraInfo, log.extraInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logId, logDate, user, constellationList, extraInfo, logLat);
    }
}
