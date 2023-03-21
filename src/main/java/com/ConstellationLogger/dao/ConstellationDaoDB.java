package com.ConstellationLogger.dao;

import com.ConstellationLogger.dto.Constellation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class ConstellationDaoDB implements ConstellationDao {

    @Autowired
    JdbcTemplate jdbc;


    @Override
    public Constellation getConstellationByAbbr(String abbr) throws DataBaseException {
        Constellation con = new Constellation();

        //SQL query to get all Constellation with Abbr = abbr
        final String SELECT_CONSTELLATION_BY_ABBR = "SELECT * FROM constellations WHERE Abbr= ?";
        //returns Constellation objects
        con = jdbc.queryForObject(SELECT_CONSTELLATION_BY_ABBR, new ConstellationMapper(), abbr);
        if(con == null){
            throw new DataBaseException("Constellation not in DataBase");
        }
        return con;
    }

    @Override
    public List<Constellation> getConstellationByMonth(int month) {
            //SQL query to get all Constellation with conMonth = month
            final String SELECT_CONSTELLATION_BY_MONTH = "SELECT * FROM constellations WHERE conMonth= ?";
            //returns a List of Constellation objects
            return jdbc.query(SELECT_CONSTELLATION_BY_MONTH, new ConstellationMapper(), month);
    }

    @Override
    public List<Constellation> getConstellationByLat(double lat) {
        //SQL query to get all Constellation with a lat between maxLat and minLat
        final String SELECT_CONSTELLATION_BY_LAT = "SELECT * FROM constellations" +
                "WHERE (maxLat >= ?  AND    minLat <= ?)";
        //returns a List of Constellation objects
        return jdbc.query(SELECT_CONSTELLATION_BY_LAT, new ConstellationMapper(), lat,lat);
    }

    @Override
    public List<Constellation> getAllConstellations() {
        //SQL query to get all the Constellation
        final String SELECT_ALL_CONSTELLATION = "SELECT * FROM constellations";
        //returns a List of Constellation objects of all Constellation
        return jdbc.query(SELECT_ALL_CONSTELLATION, new ConstellationMapper());
    }
}
