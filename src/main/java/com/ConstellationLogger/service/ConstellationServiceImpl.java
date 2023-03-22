package com.ConstellationLogger.service;

import com.ConstellationLogger.dao.ConstellationDao;
import com.ConstellationLogger.dao.LogDao;
import com.ConstellationLogger.dao.UserDao;
import com.ConstellationLogger.dto.Constellation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConstellationServiceImpl implements ConstellationService{

    public Integer monthFiltered;   //the filter for month
    public Double latFiltered;      //the filter for latitude


    @Autowired
    ConstellationDao conDao;

    @Autowired
    LogDao logDao;

    @Autowired
    UserDao userDao;

    @Override
    public List<Constellation> getAllConstellations() {
        return conDao.getAllConstellations();
    }

    @Override
    public Constellation getSingleConstellation(String abbr) {
        return conDao.getConstellationByAbbr(abbr);
    }

    @Override
    public List<Constellation> getFilteredConstellations(Integer month, Double lat) {
        List<Constellation> cons; //list to be displayed





    }
}
