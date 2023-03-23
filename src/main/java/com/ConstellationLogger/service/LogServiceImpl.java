package com.ConstellationLogger.service;

import com.ConstellationLogger.dao.ConstellationDao;
import com.ConstellationLogger.dao.DataBaseException;
import com.ConstellationLogger.dao.LogDao;
import com.ConstellationLogger.dao.UserDao;
import com.ConstellationLogger.dto.Constellation;
import com.ConstellationLogger.dto.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.ConstellationLogger.service.UserServiceImpl.currentUser;

@Component
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
    public List<Log> getLogsForUser(){
        return logDao.getAllLogsOfUser(currentUser);

    }


    @Override
    public List<Constellation> getAllConstellations(){
        return conService.getAllConstellations();
    }


    @Override
    public void addNewUser(String dateString, String logLatString, String extraInfo, String[] conAbbrs){
        Log newLog = new Log();
        Double logLat;
        LocalDate date;
        List<Constellation> logCons = new ArrayList<>();
        //parse lat and date to the rigth
        //get lat in double form and adds it to newLog
        try {
            logLat = Double.parseDouble(logLatString);
            newLog.setLogLat(logLat);
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
            newLog.setLogDate(date);
            newLog.setExtraInfo(extraInfo);
            newLog.setConstellationList(logCons);
        }catch (NullPointerException e){
            System.out.println("missing fields");
        }


        try {
            logDao.addLog(newLog);
        }catch (DataBaseException e){
            System.out.println(e.getMessage());
        }
    }



}
