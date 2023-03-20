package com.ConstellationLogger.dao;

import com.ConstellationLogger.dto.Log;
import com.ConstellationLogger.dto.User;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class LogDaoDB implements LogDao{


    @Override
    public Log getLogById(int logId) {
        return null;
    }

    @Override
    public Log getLogByDateAndUser(LocalDate date, String username) {
        return null;
    }

    @Override
    public List<Log> getAllLogsOfUser(User user) {
        return null;
    }

    @Override
    public Log addLog(Log log) {
        return null;
    }

    @Override
    public void updateLog(Log log) {

    }

    @Override
    public void deleteLog(int logId) {

    }
}
