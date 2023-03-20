package com.ConstellationLogger.dto;

public class Location {
    private int locationId;
    private String locationName;
    private double lat;


    public Location(int locationId, String locationName, double lat) {
        this.locationId = locationId;
        this.locationName = locationName;
        this.lat = lat;
    }

    public Location() {
    }

    //getters
    public int getLocationId() {
        return locationId;
    }
    public String getLocationName() {
        return locationName;
    }
    public double getLat() {
        return lat;
    }


    //setters
    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
    public void setLat(double lat) {
        this.lat = lat;
    }


    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", locationName='" + locationName + '\'' +
                ", lat=" + lat +
                '}';
    }
}
