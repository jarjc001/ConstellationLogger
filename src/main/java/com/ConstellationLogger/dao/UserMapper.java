package com.ConstellationLogger.dao;


import com.ConstellationLogger.dto.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setUserFirstName(rs.getString("userFirstName"));
        user.setUserLastName(rs.getString("userLastName"));
        user.setEmail(rs.getString("email"));
        user.setPremium(rs.getBoolean("premium"));


        return user;

    }
}
