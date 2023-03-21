package com.ConstellationLogger.dao;


import com.ConstellationLogger.dto.Log;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class LogMapper implements RowMapper<Log> {
    @Override
    public Log mapRow(ResultSet rs, int rowNum) throws SQLException {
        Log log = new Log();
        log.setLogId(rs.getInt("logId"));
        log.setLogDate(rs.getDate("logDate").toLocalDate());

       // log.setLogDate();    check to see if works

        //write extra


        log.setUser(rs.getString("username"));
        log.setLocationId(rs.getInt("locationId"));
        log.setExtraInfo(rs.getString("extraInfo"));

        return log;


    }
}
