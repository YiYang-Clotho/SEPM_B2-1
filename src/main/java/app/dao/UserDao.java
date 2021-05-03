package app.dao;

import app.models.Role;
import app.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private static final String SELECT_PWD_BY_EMAIL = "SELECT password FROM users WHERE email = ?";
    private static final String SELECT_BY_EMAIL = "SELECT email, name, role, id, phone FROM users WHERE email = ?";
    public static UserDao INSTANCE = new UserDao();
    private static String UPDATE = "UPDATE users SET email = ?, name = ?,  phone = ? WHERE id=?";

    private UserDao() {
    }

    public String getUserPasswordHash(String email) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(SELECT_PWD_BY_EMAIL);
        stm.setString(1, email);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        connection.close();
        throw new SQLException("No User with email = " + email);
    }

    public User getByEmail(String email) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(SELECT_BY_EMAIL);
        stm.setString(1, email);
        ResultSet rs = stm.executeQuery();
        if (rs.next()) {
            User user = new User();
            user.setEmail(rs.getString(1));
            user.setName(rs.getString(2));
            user.setRole(Role.valueOf(rs.getString(3)));
            user.setId(rs.getLong(4));
            user.setPhone(rs.getString(5));
            return user;
        }
        connection.close();
        throw new SQLException("No User with email = " + email);
    }

    public int update(User user) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(UPDATE);
        stm.setString(1, user.getEmail());
        stm.setString(2, user.getName());
        stm.setString(3, user.getPhone());
        return stm.executeUpdate();
    }

}


