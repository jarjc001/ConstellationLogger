package com.ConstellationLogger.controller;

import com.ConstellationLogger.dao.ConstellationDao;
import com.ConstellationLogger.dao.LogDao;
import com.ConstellationLogger.dao.UserDao;
import com.ConstellationLogger.dto.Constellation;
import com.ConstellationLogger.dto.Log;
import com.ConstellationLogger.service.ConstellationService;
import com.ConstellationLogger.service.LogService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LogController {
    @Autowired
    ConstellationDao conDao;

    @Autowired
    LogDao logDao;

    @Autowired
    UserDao userDao;

    @Autowired
    LogService logService;

    @Autowired
    ConstellationService conService;



    @GetMapping("logs")
    public String displayLogs(Model model){
        List<Log> logs = logService.getLogsForUser() ;
        List<Constellation> cons = logService.getAllConstellations();

        model.addAttribute("logs", logs);
        model.addAttribute("constellations", cons);
        return "logs";

    }


    @GetMapping("logsDetail")
    public String logsDetail(Integer logId, Model model) {
        return "logsDetail";

    }




    @PostMapping("createLog")
    public String createUser(HttpServletRequest request){
        String date = request.getParameter("logDate");
        String logLat = request.getParameter("logLat");
        String extraInfo = request.getParameter("extraInfo");

        String[] conAbbrs = request.getParameterValues("abbr");

        logService.addNewUser(date,logLat,extraInfo,conAbbrs);

        return "redirect:/logs";

    }


    @GetMapping("deleteLog")
    public String deleteLog(Integer logId){
        logDao.deleteLog(logId);


        return "redirect:/conLogs";
    }

}
