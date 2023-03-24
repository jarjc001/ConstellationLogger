package com.ConstellationLogger.service;

import com.ConstellationLogger.dao.ConstellationDao;
import com.ConstellationLogger.dao.DataBaseException;
import com.ConstellationLogger.dao.LogDao;
import com.ConstellationLogger.dao.UserDao;
import com.ConstellationLogger.dto.Constellation;
import com.ConstellationLogger.dto.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.ConstellationLogger.service.UserServiceImpl.currentUser;

@Service
public class LogServiceImpl implements LogService{

    @Autowired
    ConstellationDao conDao;

    @Autowired
    LogDao logDao;

    @Autowired
    UserDao userDao;

    @Autowired
    ConstellationService conService;

    @Autowired
    UserService userService;


    @Override
    public boolean checkLoggedIn(){
        if(currentUser.getUsername().equals("")){   //no one is logged in
            return false;
        }else {                     //is logged in
            return true;
        }
    }


    @Override
    public List<Log> getLogsForUser(){
        return logDao.getAllLogsOfUser(currentUser);

    }



    @Override
    public Log getSingleLog(Integer logId){
        Log log = new Log();
        try {
            log = logDao.getLogById(logId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return log;
    }


    @Override
    public List<Constellation> getAllConstellations(){
        return conService.getAllConstellations();
    }


    @Override
    public Log createNewLog(String dateString, String logLatString, String extraInfo, String[] conAbbrs, Log newLog){

        //check if there are some iwth same date and lat

        Double logLat;
        LocalDate date;
        List<Constellation> logCons = new ArrayList<>();
        //parse lat and date to the rigth
        //get lat in double form and adds it to newLog
        try {
            logLat = Double.parseDouble(logLatString);
        }catch (Exception e){
            logLat = null;
        }
        //gets date in localDate form
        try {
            date = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }catch (Exception e){
            date = null;
        }
        //creates a list of Constellations from conAbbrs
        try {
            for (String abbr : conAbbrs) {
                logCons.add(conService.getSingleConstellation(abbr));
            }
        }catch (NullPointerException e){
            logCons = new ArrayList<>();
        }

        try {
            //adds rest of the parts to newLog

            newLog.setUser(currentUser);
            newLog.setLogLat(logLat);
            newLog.setLogDate(date);
            newLog.setExtraInfo(extraInfo);
            newLog.setConstellationList(logCons);
        }catch (NullPointerException e){
            System.out.println("missing fields");
        }


        return newLog;
    }

    @Override
    public Log addLogToDB(String dateString, String logLatString, String extraInfo, String[] conAbbrs){
        Log newLog = new Log();
        newLog = createNewLog(dateString, logLatString, extraInfo, conAbbrs, newLog);
        try {
            logDao.addLog(newLog);
        }catch (DataBaseException e){
            System.out.println(e.getMessage());
        }
        return newLog;
    }

    @Override
    public void updateLogToDB(Integer logId, String dateString, String logLatString, String extraInfo, String[] conAbbrs){
        Log newLog = new Log();
        newLog.setLogId(logId);
        newLog = createNewLog(dateString, logLatString, extraInfo, conAbbrs, newLog);
        try {
            logDao.updateLog(newLog);
        }catch (DataBaseException e){
            System.out.println(e.getMessage());
        }
    }






    @Override
    public void removeLog(Integer logId){
        logDao.deleteLog(logId);
    }



}
