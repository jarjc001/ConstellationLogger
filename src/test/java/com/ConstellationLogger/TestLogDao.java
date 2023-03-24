package com.ConstellationLogger;

import com.ConstellationLogger.dao.ConstellationDao;
import com.ConstellationLogger.dao.DataBaseException;
import com.ConstellationLogger.dao.LogDao;
import com.ConstellationLogger.dao.UserDao;

import com.ConstellationLogger.dto.Constellation;
import com.ConstellationLogger.dto.Log;
import com.ConstellationLogger.dto.User;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
public class TestLogDao {

    @Autowired
    ConstellationDao conDao;

    @Autowired
    LogDao logDao;

    @Autowired
    UserDao userDao;


    String testUsername = "testUsername";
    String testPassword = "testUsername";
    String testFirstName = "testFirstName";
    String testLastName = "testLastName";
    String testEmail = "testEmail@mail.com";
    Boolean testPremium = true;
    User testUser = new User(testUsername,testPassword,testFirstName,testLastName, testEmail, testPremium);


    int testLogId;
    LocalDate testDate = LocalDate.ofEpochDay(2020-12-12);
    Double testLat = 50.0;
    String testExtraInfo = "Test Log";
    List<Constellation> testConList = new ArrayList<>();
    Log testLog = new Log();



    public TestLogDao() {
    }



    @BeforeEach
    public void setup(){
        if(userDao.checkUsernameInDataBase(testUsername)) { //makes suer test user is in database
            userDao.deleteUser(testUsername, testUsername);
        }
        userDao.addUser(testUser);

        List<Log> logs = logDao.getAllLogsOfUser(testUser);
        for (Log log : logs){
            logDao.deleteLog(log.getLogId());
        }

        testLog = new Log(); //creates a log with the info that would be inputted

        testLog.setUser(testUser);
        testLog.setLogDate(testDate);
        testLog.setLogLat(testLat);
        testLog.setConstellationList(testConList);
        testLog.setExtraInfo(testExtraInfo);

        try {
            testLog = logDao.addLog(testLog);
        } catch (DataBaseException e) {
            System.out.println(e.getMessage());
        }

        //the assigned log id
        testLogId = testLog.getLogId();

    }




    @Test
    void testAddLog() {
        //adds to database already


        //gets the log from database
        Log addedTestLog = new Log();
        try {
            addedTestLog = logDao.getLogById(testLogId);
        } catch (DataBaseException e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(testLog,addedTestLog,"Adding a new log to db");

    }

    @Test
    void testDeleteLog() {
        logDao.deleteLog(testLogId);           //delete log from db

        //gets the deleted log from database, should trigger exception
        Log deletedTestLog = new Log();
        try {
            deletedTestLog = logDao.getLogById(testLogId);
        } catch (DataBaseException e) {
            deletedTestLog = null;
        }

        Assertions.assertNull(deletedTestLog, "Should be null if log is deleted");
                //(testLog,addedTestLog,"Adding a new log to db");

    }


    @Test
    void testEditLog() {
        //will modifily testLog so it can be updated

        LocalDate testEditDate = LocalDate.ofEpochDay(20210-11-11);
        Double testEditLat = 60.0;
        String testEditExtraInfo = "Test Log edited";

        testLog.setLogDate(testEditDate);
        testLog.setLogLat(testEditLat);
        testLog.setExtraInfo(testEditExtraInfo);

        try {
            logDao.updateLog(testLog);
        } catch (DataBaseException e) {
            System.out.println(e.getMessage());
        }

        //gets the log from database
        Log editedTestLog = new Log();
        try {
            editedTestLog = logDao.getLogById(testLogId);
        } catch (DataBaseException e) {
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(testLog,editedTestLog,"editing log to db");





    }

}
