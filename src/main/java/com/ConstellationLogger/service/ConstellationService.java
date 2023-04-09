package com.ConstellationLogger.service;

import com.ConstellationLogger.dto.Constellation;

import java.util.List;

public interface ConstellationService {


    Integer getMonthFiltered();

    Double getLatFiltered();

    /**
     * Gets the full list of Constellations from the DataBase
     * @return list of Constellation objects
     */
    public List<Constellation> getAllConstellations();


    /**
     * Get a single Constellation from the database from its abbreviations
     * @param abbr Constellation's abbreviation
     * @return Constellation object
     */
    public Constellation getSingleConstellation(String abbr);

    /**
     * Get a list of Constellations based the filters given, or give a full list if no filters given
     * @return list of Constellation objects
     */
    public List<Constellation> displayFilteredConstellations();

    /**
     * Changes the filters and gets the list of Constellations from it.
     * It takes in the Strings of the month and latitude, parse them into the right object.
     * @param monthString month of filter
     * @param latString latitude
     * @return list of Constellation objects
     */
    public List<Constellation> ablyFilteredConstellations(String monthString, String latString);



}
