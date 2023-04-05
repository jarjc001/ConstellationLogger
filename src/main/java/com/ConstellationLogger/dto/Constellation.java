package com.ConstellationLogger.dto;

import java.util.Objects;

public class Constellation {

    private String abbr;
    private String latinName;
    private String englishName;
    private int conMonth;
    private double maxLat;
    private double minLat;
    private String brightStar;
    private String extraInfo;
    private String imageUrl;


    /**Construtor for mapping from database
     */
    public Constellation(String abbr, String latinName, String englishName, int conMonth, double maxLat, double minLat, String brightStar, String imageUrl) {
        this.abbr = abbr;
        this.latinName = latinName;
        this.englishName = englishName;
        this.conMonth = conMonth;
        this.maxLat = maxLat;
        this.minLat = minLat;
        this.brightStar = brightStar;
        //this.extraInfo = extraInfo;
        this.imageUrl = imageUrl;
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
    public String getImageUrl(){return this.imageUrl;}

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
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
                ", imageUrl='"+ imageUrl + '\''+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constellation that = (Constellation) o;
        return conMonth == that.conMonth && Double.compare(that.maxLat, maxLat) == 0 && Double.compare(that.minLat, minLat) == 0 && Objects.equals(abbr, that.abbr) && Objects.equals(latinName, that.latinName) && Objects.equals(englishName, that.englishName) && Objects.equals(brightStar, that.brightStar) && Objects.equals(extraInfo, that.extraInfo) && Objects.equals(imageUrl, that.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abbr, latinName, englishName, conMonth, maxLat, minLat, brightStar, extraInfo, imageUrl);
    }
}
