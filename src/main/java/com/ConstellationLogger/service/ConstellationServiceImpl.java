package com.ConstellationLogger.service;

import com.ConstellationLogger.dao.ConstellationDao;
import com.ConstellationLogger.dao.LogDao;
import com.ConstellationLogger.dao.UserDao;
import com.ConstellationLogger.dto.Constellation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConstellationServiceImpl implements ConstellationService{

    /**The current filter for month*/
    protected Integer monthFiltered;   //the filter for month
    /**The current filter for latitude */
    protected Double latFiltered;      //the filter for latitude


    @Autowired
    ConstellationDao conDao;

    @Override
    public List<Constellation> getAllConstellations() {
        monthFiltered = null;
        latFiltered = null;
        return conDao.getAllConstellations();
    }

    @Override
    public Constellation getSingleConstellation(String abbr) {
        return conDao.getConstellationByAbbr(abbr);
    }

    @Override
    public List<Constellation> displayFilteredConstellations() {
        List<Constellation> cons = null; //list to be displayed
        try {

            if ((latFiltered != null) && (monthFiltered != null)) { //both filters on
                cons=conDao.getConstellationByLatAndMonth(latFiltered,monthFiltered);
            }else if(latFiltered != null){
                cons=conDao.getConstellationByLat(latFiltered);
            }else if(monthFiltered != null){
                cons=conDao.getConstellationByMonth(monthFiltered);
            }else{
                cons = getAllConstellations();
            }
        } catch (Exception e) {
//            monthFiltered = null;
//            latFiltered = null;
           // cons = getAllConstellations();
        }
        return cons;
    }

    @Override
    public List<Constellation> ablyFilteredConstellations(String monthString, String latString){

        Integer month;
        Double lat;

        try {

            month = Integer.parseInt(monthString);
        }catch (Exception e){
            month = null;
        }
        try {
            lat = Double.parseDouble(latString);
        }catch (Exception e){
            lat = null;
        }

        monthFiltered = month;
        latFiltered = lat;
        return displayFilteredConstellations();

    }
}
