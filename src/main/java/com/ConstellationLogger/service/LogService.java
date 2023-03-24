package com.ConstellationLogger.service;

import com.ConstellationLogger.dto.Constellation;
import com.ConstellationLogger.dto.Log;

import java.util.List;

public interface LogService {

    boolean checkLoggedIn();

    /**Gets a list of logs for the current user,
     * If there is no current user, it will return null
     * @return list of logs
     */
    List<Log> getLogsForUser();

    /**Get a single Log from its log ID
     * @param logId log id
     * @return log object
     */
    Log getSingleLog(Integer logId);

    /**Gets a list of all Constellations,
     * For drop down menus of constellations to add or edit a log
     * @return list of all constellations
     */
    List<Constellation> getAllConstellations();

    /**Creates a log object for the new log, from user input.
     * Will parse date and logLat to the correct object type
     * @param date date
     * @param logLat latitude
     * @param extraInfo extra info
     * @param conAbbrs lift of Constellations abbrs
     */
    Log createNewLog(String date, String logLat, String extraInfo, String[] conAbbrs, Log newLog);

    Log addLogToDB(String dateString, String logLatString, String extraInfo, String[] conAbbrs);


    void updateLogToDB(Integer logId, String dateString, String logLatString, String extraInfo, String[] conAbbrs);

    /**
     * Remove a Log from the database based on its log id
     * @param logId log ID
     */
    void removeLog(Integer logId);
}
