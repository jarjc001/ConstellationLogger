package com.ConstellationLogger.dao;

import com.ConstellationLogger.dto.Constellation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class ConstellationMapper implements RowMapper<Constellation> {
    @Override
    public Constellation mapRow(ResultSet rs, int rowNum) throws SQLException {
        Constellation con = new Constellation();
        con.setAbbr(rs.getString("Abbr"));
        con.setLatinName(rs.getString("latinName"));
        con.setEnglishName(rs.getString("englishName"));
        con.setConMonth(rs.getInt("conMonth"));
        con.setMaxLat(rs.getDouble("maxLat"));
        con.setMinLat(rs.getDouble("minLat"));
        con.setBrightStar(rs.getString("brightStar"));
        con.setExtraInfo(rs.getString("extraInfo"));
        con.setImageUrl(rs.getString("image"));
        return con;

    }
}
