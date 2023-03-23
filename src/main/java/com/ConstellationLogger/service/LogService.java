package com.ConstellationLogger.service;

import com.ConstellationLogger.dto.Constellation;
import com.ConstellationLogger.dto.Log;

import java.time.LocalDate;
import java.util.List;

public interface LogService {

    /**Gets a list of logs for the current user,
     * If there is no current user, it will return null
     * @return list of logs
     */
    List<Log> getLogsForUser();

    /**Gets a list of all Constellations,
     * For drop down menus of constellations to add or edit a log
     * @return list of all constellations
     */
    List<Constellation> getAllConstellations();

    /**Creates a log object for the new log, then adds it to Database.
     * Will parse date and logLat to the correct object type
     * @param date date
     * @param logLat latitude
     * @param extraInfo extra info
     * @param conAbbrs lift of Constellations abbrs
     */
    void addNewUser(String date, String logLat, String extraInfo, String[] conAbbrs);
}
