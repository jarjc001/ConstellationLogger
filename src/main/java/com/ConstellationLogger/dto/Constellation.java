package com.ConstellationLogger.dto;

public class Constellation {

    private String abbr;
    private String latinName;
    private String englishName;
    private int conMonth;
    private double maxLat;
    private double minLat;
    private String brightStar;
    private String extraInfo;


    /**Construtor for mapping from database
     */
    public Constellation(String abbr, String latinName, String englishName, int conMonth, double maxLat, double minLat, String brightStar) {
        this.abbr = abbr;
        this.latinName = latinName;
        this.englishName = englishName;
        this.conMonth = conMonth;
        this.maxLat = maxLat;
        this.minLat = minLat;
        this.brightStar = brightStar;
    }

    public Constellation() {
    }


    ///addd one to have extra info maybe


    //getters
    public String getAbbr() {
        return this.abbr;
    }
    public String getLatinName() {
        return this.latinName;
    }
    public String getEnglishName() {
        return this.englishName;
    }
    public int getConMonth() {
        return this.conMonth;
    }
    public double getMaxLat() {
        return this.maxLat;
    }
    public double getMinLat() {
        return this.minLat;
    }
    public String getBrightStar() {
        return this.brightStar;
    }
    public String getExtraInfo() {
        return this.extraInfo;
    }

    //setters
    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }
    public void setLatinName(String latinName) {
        this.latinName = latinName;
    }
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }
    public void setConMonth(int conMonth) {
        this.conMonth = conMonth;
    }
    public void setMaxLat(double maxLat) {
        this.maxLat = maxLat;
    }
    public void setMinLat(double minLat) {
        this.minLat = minLat;
    }
    public void setBrightStar(String brightStar) {
        this.brightStar = brightStar;
    }
    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }


    @Override
    public String toString() {
        return "Constellation{" +
                "abbr='" + abbr + '\'' +
                ", latinName='" + latinName + '\'' +
                ", englishName='" + englishName + '\'' +
                ", conMonth=" + conMonth +
                ", maxLat=" + maxLat +
                ", minLat=" + minLat +
                ", brightStar='" + brightStar + '\'' +
                ", extraInfo='" + extraInfo + '\'' +
                '}';
    }
}