package com.ConstellationLogger.dao;


import com.ConstellationLogger.dto.Location;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class LocationMapper implements RowMapper<Location> {
    @Override
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location loc = new Location();
        loc.setLocationId(rs.getInt(""));
        loc.setLocationName(rs.getString(""));
        loc.setLat(rs.getDouble(""));
        return loc;
    }
}
