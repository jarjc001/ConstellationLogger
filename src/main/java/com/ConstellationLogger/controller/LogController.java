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

import static com.ConstellationLogger.service.LogServiceImpl.logViolations;


@Controller
public class LogController {

    @Autowired
    LogService logService;


    /**
     * Displays the logs of the current, logged-in user. If the user is not logged-in,
     * it will redirect the user to the login page
     * @param model model
     */
    @GetMapping("logs")
    public String displayLogs(Model model){
        if(!logService.checkLoggedIn()){        //take them to login screen if they are not logged in
            return "redirect:/login";
        }

        model.addAttribute("errors", logViolations);

        List<Log> logs = logService.getLogsForUser() ;
        List<Constellation> cons = logService.getAllConstellations();

        model.addAttribute("logs", logs);
        model.addAttribute("constellations", cons);
        return "logs";

    }

    /**The details of the chosen log
     * @param logId the id of the chosen log
     * @param model model
     */
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


    /**
     * Creates a new log for the current, logged-in user.
     * @param request HttpServletRequest
     */
    @PostMapping("createLog")
    public String createLog(HttpServletRequest request){
        String date = request.getParameter("logDate");
        String logLat = request.getParameter("logLat");
        String extraInfo = request.getParameter("extraInfo");

        String[] conAbbrs = request.getParameterValues("abbr");

        logService.addLogToDB(date,logLat,extraInfo,conAbbrs);

        return "redirect:/logs";

    }

    /**Edits the chosen log for the current, logged-in user.
     * @param logId the id of the chosen log
     * @param request HttpServletRequest
     */
    @PostMapping("editLog")
    public String editLog(Integer logId, HttpServletRequest request){
        String date = request.getParameter("editLogDate");
        String logLat = request.getParameter("editLogLat");
        String extraInfo = request.getParameter("editExtraInfo");

        String[] conAbbrs = request.getParameterValues("editAbbr");

        logService.updateLogToDB(logId,date,logLat,extraInfo,conAbbrs);

        return "redirect:/logs";

    }

    /**
     * Delete the chosen log
     * @param logId the id of the chosen log
     */
    @GetMapping("deleteLog")
    public String deleteLog(Integer logId){
        logService.removeLog(logId);
        return "redirect:/logs";
    }

}
