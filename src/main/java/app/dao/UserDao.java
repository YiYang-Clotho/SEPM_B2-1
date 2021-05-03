package app.dao;

import app.models.Role;
import app.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static final String SELECT_PWD_BY_EMAIL = "SELECT password FROM users WHERE email = ?";
    private static final String SELECT_BY_EMAIL = "SELECT email, name, role, id FROM users WHERE email = ?";
    private static String SELECT_ALL = "SELECT * FROM users";
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
            return user;
        }
        connection.close();
        throw new SQLException("No User with email = " + email);
    }

    public List<User> getAll() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(SELECT_ALL);
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(mapUser_ALL(rs));
        }
        connection.close();
        return users;
    }

    public int update(User user) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(UPDATE);
        stm.setString(1, user.getEmail());
        stm.setString(2, user.getName());
        stm.setString(3, user.getPhone());
        return stm.executeUpdate();
    }

    private User mapUser_ALL(ResultSet rs) throws SQLException {
        User user = new User(rs.getString(2),
                rs.getString(3),
                rs.getString(5),
                rs.getString(6)
                );
        user.setId(rs.getLong(1));
        user.setRole(Role.valueOf(rs.getString(4)));
        return user;
    }

}
