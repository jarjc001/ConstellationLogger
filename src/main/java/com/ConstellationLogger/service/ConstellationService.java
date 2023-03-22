package com.ConstellationLogger.service;

import com.ConstellationLogger.dto.Constellation;

import java.util.List;

public interface ConstellationService {

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
     * @param month month of filter
     * @param lat latitude
     * @return list of Constellation objects
     */
    public List<Constellation> getFilteredConstellations(Integer month, Double lat);



}
