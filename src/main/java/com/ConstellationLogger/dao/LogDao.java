package com.ConstellationLogger.dao;

import com.ConstellationLogger.dto.Constellation;
import com.ConstellationLogger.dto.Log;
import com.ConstellationLogger.dto.User;

import java.time.LocalDate;
import java.util.List;

public interface LogDao {

    /**Get the log info from it log Id
     * @param logId log id
     * @return Log Object
     */
    Log getLogById (int logId) throws DataBaseException;

    /**Get the log info from the date and the username
     * @param date log date
     * @param username username
     * @return log object
     */
    Log getLogByDateAndUser(LocalDate date, String username);

    /**Get a list of all the logs for a given user
     * @param user user
     * @return list of logs
     */
    List<Log> getAllLogsOfUser(User user);

    /**Add a log to the database
     * @param log new log
     * @return the log that was added to database
     */
    Log addLog(Log log) throws DataBaseException;

    /**Update a log in a database
     * @param log the log with the updated info
     */
    void updateLog(Log log);

    /**Delete a log from the database
     * @param logId log id of log to be deleted
     */
    void deleteLog(int logId);





}
