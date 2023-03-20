package com.ConstellationLogger.dao;

import com.ConstellationLogger.dto.Constellation;

import java.util.List;


public interface ConstellationDao {


    /**Gets a Constellation from its abbreviations
     * @param abbr Constellation's abbreviation
     * @return Constellation object
     */
    Constellation getConstellationByAbbr (String abbr) throws DataBaseException;


    /**Gets a List Constellation from its month
     * @param month Constellation's month
     * @return List of Constellations
     */
    List<Constellation> getConstellationByMonth (int month) throws DataBaseException;


    /**Gets a List Constellation from a given latitude
     * @param lat latitude
     * @return list of Constellation
     */
    List<Constellation> getConstellationByLat(double lat);

    /**Gets a List of all Constellations
     * @return List of Constellations
     */
    List<Constellation> getAllConstellations ();


}
