package com.ConstellationLogger.controller;

import com.ConstellationLogger.dao.ConstellationDao;
import com.ConstellationLogger.dao.LogDao;
import com.ConstellationLogger.dao.UserDao;
import com.ConstellationLogger.dto.Constellation;
import com.ConstellationLogger.dto.Log;
import com.ConstellationLogger.service.LogService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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




    @GetMapping("logs")
    public String displayLogs(Model model){
        if(!logService.checkLoggedIn()){        //take them to login screen if they are not logged in
            return "redirect:/login";
        }

        List<Log> logs = logService.getLogsForUser() ;
        List<Constellation> cons = logService.getAllConstellations();

        model.addAttribute("logs", logs);
        model.addAttribute("constellations", cons);
        return "logs";

    }


    @GetMapping("logsDetail")
    public String logsDetail(Integer logId, Model model) {

        Log log = logService.getSingleLog(logId);
        model.addAttribute("log",log);

        List<Log> logs = logService.getLogsForUser() ;
        List<Constellation> cons = logService.getAllConstellations();

        model.addAttribute("logs", logs);
        model.addAttribute("constellations", cons);

        return "logsDetail";

    }




    @PostMapping("createLog")
    public String createLog(HttpServletRequest request){
        String date = request.getParameter("logDate");
        String logLat = request.getParameter("logLat");
        String extraInfo = request.getParameter("extraInfo");

        String[] conAbbrs = request.getParameterValues("abbr");

        logService.addLogToDB(date,logLat,extraInfo,conAbbrs);

        return "redirect:/logs";

    }


    @PostMapping("logsDetail")
    public String editLog(Integer logId, HttpServletRequest request){
        String date = request.getParameter("editLogDate");
        String logLat = request.getParameter("editLogLat");
        String extraInfo = request.getParameter("editExtraInfo");

        String[] conAbbrs = request.getParameterValues("editAbbr");

        logService.updateLogToDB(logId,date,logLat,extraInfo,conAbbrs);

        return "redirect:/logs";



    }

    @GetMapping("deleteLog")
    public String deleteLog(Integer logId){
        logService.removeLog(logId);
        return "redirect:/logs";
    }

}
