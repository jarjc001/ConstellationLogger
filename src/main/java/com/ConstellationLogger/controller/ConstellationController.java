package com.ConstellationLogger.controller;

import com.ConstellationLogger.dao.ConstellationDao;
import com.ConstellationLogger.dao.LogDao;
import com.ConstellationLogger.dao.UserDao;
import com.ConstellationLogger.dto.Constellation;
import com.ConstellationLogger.service.ConstellationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;


@Controller
public class ConstellationController {

    @Autowired
    ConstellationService conService;

    /**Displays the list of Constellations based on the current filters
     * @param model model to send to html
     * @param cons  the list of constellation objects tobe displayed
     * @return the url
     */
    public String  displayConstellations(Model model, List<Constellation> cons){
        //List<Constellation> cons = conService.getAllConstellations();
        model.addAttribute("constellations", cons);
        model.addAttribute("monthFiltered",conService.getMonthFiltered());
        model.addAttribute("latFiltered",conService.getLatFiltered());
        //set monthFiltered and lat fltered to zero;
        return "constellations";

    }

    /**
     * Get all constellations as a list
     */
    @GetMapping("constellations")
    public String displayAllConstellations(Model model){
        List<Constellation> cons = conService.getAllConstellations();
        return displayConstellations(model, cons);
    }

    /**
     * Get all the constellations based on a set filter: the latitude and the month, as a list
     * @param request HttpServletRequest
     * @param model model
     */
    @GetMapping("constellationsFilter")
    public String constellationsFilter(HttpServletRequest request , Model model){
             String month = request.getParameter("month");
             String lat = request.getParameter("lat");
        List<Constellation> cons = conService.ablyFilteredConstellations(month,lat);

        return displayConstellations(model,cons);
    }

    /**
     * Gets the details of the chosen constellation, including its picture.
     * @param abbr the constellation's abbr
     * @param model model
     */
    @GetMapping("constellationDetail")
    public String constellationDetail(String abbr, Model model){
        Constellation con = conService.getSingleConstellation(abbr);
        model.addAttribute("constellation",con);

        List<Constellation> cons = conService.displayFilteredConstellations(); //list to be displayed aswell

        displayConstellations(model,cons);

        return "constellationDetail";

    }






}
