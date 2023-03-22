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

//    public Integer monthFiltered;   //the filter for month
//    public Double latFiltered;      //the filter for latitude

    @Autowired
    ConstellationDao conDao;

    @Autowired
    ConstellationService conService;

    @Autowired
    LogDao logDao;

    @Autowired
    UserDao userDao;

    @GetMapping("constellations")
    public String  displayConstellations(Model model){
        List<Constellation> cons = conService.getAllConstellations();
        model.addAttribute("constellations", cons);
        //set monthFiltered and lat fltered to zero;
        return "constellations";

    }


    @GetMapping("constellationDetail")
    public String constellationDetail(String abbr, Model model){
        Constellation con = conService.getSingleConstellation(abbr);
        model.addAttribute("constellation",con);

        List<Constellation> cons = conService.displayFilteredConstellations(); //list to be displayed aswell

        model.addAttribute("constellations", cons);

        return "constellationDetail";

    }

    @GetMapping("constellationsFilter")
    public String constellationsMonth(HttpServletRequest request , Model model){

        Integer month;
        Double lat;


        try {

             month = Integer.parseInt(request.getParameter("month"));
        }catch (Exception e){
             month = null;
        }

        try {
             lat = Double.parseDouble(request.getParameter("lat"));
        }catch (Exception e){
             lat = null;
        }






        //latFiltered = Double.parseDouble(request.getParameter("lat")); //add when we get the service filter method

        List<Constellation> cons = conService.ablyFilteredConstellations(month,lat);

//        try {
//            conService.MonthFiltered= Integer.parseInt(request.getParameter("month"));
//            conService.latFiltered = Double.parseDouble(request.getParameter("lat"));
//            conService.displayFilteredConstellations()
//            cons = conDao.getConstellationByMonth(monthFiltered);
//
//        } catch (Exception  e) {     //in case of error, will just give the full list and clear filters
//            monthFiltered = null;
//            latFiltered = null;
//            cons = conDao.getAllConstellations();
//
//        }
        model.addAttribute("constellations", cons);
        return "constellationsFilter";



    }




}
