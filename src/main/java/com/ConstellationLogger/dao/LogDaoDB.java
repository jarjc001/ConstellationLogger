package com.ConstellationLogger.dao;

import com.ConstellationLogger.dto.Constellation;
import com.ConstellationLogger.dto.Log;
import com.ConstellationLogger.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository
public class LogDaoDB implements LogDao{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public Log getLogById(int logId) throws DataBaseException {
        Log log = new Log();
        try {
            final String SELECT_LOG_BY_ID = "SELECT * FROM log WHERE logId= ?";
            log = jdbc.queryForObject(SELECT_LOG_BY_ID, new LogMapper(), logId);
            log.setConstellationList(getConstellationForLog(logId));
            log.setUser(getUserForLog(logId));
        }catch (Exception e){
            throw new DataBaseException("Log not in Database",e);
        }

        return log;
    }

    @Override
    public Log getLogByDateAndUser(LocalDate date, String username) {
        return null;  ///add if have time, for searching for the log
    }


    /**Used to get a list of Constellations that are linked to a log of logID
     * @param logId log id
     * @return List of Constellations linked to log
     */
    private List<Constellation> getConstellationForLog(int logId){
        final String SELECT_CONSTELLATION_FOR_LOG = "SELECT c.* FROM constellations c " +
                "JOIN constellationsLog cl ON cl.Abbr = c.Abbr WHERE cl.logId = ?";
        return jdbc.query(SELECT_CONSTELLATION_FOR_LOG, new ConstellationMapper(), logId);
    }

    /**Used to get a User that is linked to the log of logID
     * @param logId log id
     * @return User linked to log
     */
    private User getUserForLog(int logId){
        String SELECT_USER_FOR_LOG = "SELECT u.* FROM users u " +
                "JOIN log l ON l.username = u.username WHERE l.logId = ?";
        return jdbc.queryForObject(SELECT_USER_FOR_LOG, new UserMapper(), logId);
    }



    @Override
    public List<Log> getAllLogsOfUser(User user) {
        final String SELECT_ALL_LOGS_OF_USER = "SELECT * FROM users WHERE username= ?";
        List<Log> logs = jdbc.query(SELECT_ALL_LOGS_OF_USER, new LogMapper(), user.getUsername());
        assignConstellationsAndUser(logs);
        return logs;
    }


    /**Assign Constellations and Users to a list of Logs
     * @param logs list of logs
     */
    private void assignConstellationsAndUser(List<Log> logs){
        for (Log log : logs){
            log.setConstellationList(getConstellationForLog(log.getLogId()));
            log.setUser(getUserForLog(log.getLogId()));
        }
    }

    @Override
    @Transactional
    public Log addLog(Log log) {
        final String INSERT_LOG = "INSERT INTO log(logDate, locationName, Lat, extraInfo, username) " +
                "VALUES(?, ?, ?, ?, ?)";
        jdbc.update(INSERT_LOG,
                log.getLogDate(),
                log.getLocationName(),
                log.getLat(),
                log.getExtraInfo(),
                log.getUser().getUsername());
        //get the newly made id of the added log
        int newId =jdbc.queryForObject("SELECT LAST_INSERT_ID()",Integer.class);
        log.setLogId(newId);
        //add the list of Constellations to the log in database
        insertConstellationsLog(log);
        return log;
    }

    /**Insert the list of Constellations for a log into Database
     * @param log log
     */
    private void insertConstellationsLog(Log log){
        final String INSERT_CONSTELLATION_LOG = "INSERT INTO " +
                "constellationsLog(Abbr, logId) VALUES(?, ?)";
        for(Constellation con: log.getConstellationList()){
            jdbc.update(INSERT_CONSTELLATION_LOG,
                    con.getAbbr(),
                    log.getLogId());
        }

    }

    @Override
    @Transactional
    public void updateLog(Log log) {
        final String UPDATE_LOG = "UPDATE log SET logDate = ?, locationName = ?," +
                " Lat = ?, extraInfo = ? WHERE logId = ?";

        jdbc.update(UPDATE_LOG,
                log.getLogDate(),
                log.getLocationName(),
                log.getLat(),
                log.getExtraInfo(),
                log.getLogId());
        //delete old Constellations list and add a new one
        final String DELETE_CONSTELLATION_LOG = "DELETE FROM constellationsLog WHERE logId = ?";
        jdbc.update(DELETE_CONSTELLATION_LOG,log.getLogId() );
        insertConstellationsLog(log);

    }

    @Override
    @Transactional
    public void deleteLog(int logId) {
        final String DELETE_CONSTELLATION_LOG = "DELETE FROM constellationsLog WHERE logId = ?";
        jdbc.update(DELETE_CONSTELLATION_LOG,logId);

        final String DELETE_LOG = "DELETE FROM log WHERE logId = ?";
        jdbc.update(DELETE_LOG,logId);

    }
}
