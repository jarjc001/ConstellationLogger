package com.ConstellationLogger.dao;

import com.ConstellationLogger.dto.Constellation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConstellationDaoDB implements ConstellationDao {
    @Override
    public Constellation getConstellationByAbbr(String abbr) {
        return null;
    }

    @Override
    public List<Constellation> getConstellationByMonth(int month) {
        return null;
    }

    @Override
    public List<Constellation> getAllConstellations() {
        return null;
    }
}
