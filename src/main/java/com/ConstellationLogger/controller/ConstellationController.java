package com.ConstellationLogger.controller;

import com.ConstellationLogger.dao.ConstellationDao;
import com.ConstellationLogger.dao.DataBaseException;
import com.ConstellationLogger.dao.LogDao;
import com.ConstellationLogger.dao.UserDao;
import com.ConstellationLogger.dto.Constellation;
import jakarta.servlet.http.HttpServletRequest;
import com.ConstellationLogger.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class ConstellationController {

    public Integer monthFiltered;   //the filter for month
    public Double latFiltered;      //the filter for latitude

    @Autowired
    ConstellationDao conDao;

    @Autowired
    LogDao logDao;

    @Autowired
    UserDao userDao;

    @GetMapping("constellations")
    public String  displayConstellations(Model model){
        List<Constellation> cons = conDao.getAllConstellations();
        model.addAttribute("constellations", cons);
        //set monthFiltered and lat fltered to zero;
        monthFiltered = null;
        latFiltered = null;
        return "constellations";

    }


    @GetMapping("constellationDetail")
    public String constellationDetail(String abbr, Model model){
        Constellation con = conDao.getConstellationByAbbr(abbr);
        model.addAttribute("constellation",con);

        List<Constellation> cons; //list to be displayed aswell


        if((monthFiltered == null)&&(latFiltered == null) ){    //no filters are in place
            cons = conDao.getAllConstellations();
            model.addAttribute("constellations", cons);
        }else {             // a filter is in place
            try {
            cons = conDao.getConstellationByMonth(monthFiltered);

            } catch (Exception  e) {     //in case of error, will just give the full list
                cons = conDao.getAllConstellations();
            }

            model.addAttribute("constellations", cons);
        }

        return "constellationDetail";

    }

    @GetMapping("constellationsFilter")
    public String constellationsMonth(HttpServletRequest request , Model model){

        //latFiltered = Double.parseDouble(request.getParameter("lat")); //add when we get the service filter method

        List<Constellation> cons;

        try {
            monthFiltered = Integer.parseInt(request.getParameter("month"));
            cons = conDao.getConstellationByMonth(monthFiltered);

        } catch (Exception  e) {     //in case of error, will just give the full list and clear filters
            monthFiltered = null;
            latFiltered = null;
            cons = conDao.getAllConstellations();

        }
        model.addAttribute("constellations", cons);
        return "constellationsFilter";



    }




}
