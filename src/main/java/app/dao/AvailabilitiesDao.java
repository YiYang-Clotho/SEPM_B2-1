package app.dao;

import app.models.Availability;
import app.models.Shift;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvailabilitiesDao {

    public static AvailabilitiesDao INSTANCE = new AvailabilitiesDao();

    private static String SELECT_ALL = "SELECT * FROM availabilities";
    //    private static String SELECT_BY_ID = "SELECT * FROM cinemas WHERE id=?";
    private static String INSERT = "INSERT INTO availabilities(start_time, end_time, staff_name) VALUES(?,?,?)";
//    private static String UPDATE = "UPDATE cinemas SET location = ?, tel = ?  WHERE id=?";
//    private static String REMOVE_CINEMA = "DELETE FROM cinemas WHERE id=?";

    private AvailabilitiesDao(){
    }

    public List<Availability> getAll() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(SELECT_ALL);
        List<Availability> availabilities = new ArrayList<>();
        while (rs.next()) {
            availabilities.add(mapAvailability_ALL(rs));
        }
        connection.close();
        return availabilities;
    }

//    public List<Availability> getAll() throws SQLException {
//        Connection connection = DBUtils.getConnection();
//        Statement stm = connection.createStatement();
//        ResultSet rs = stm.executeQuery(SELECT_ALL);
//        List<Availability> availabilities = new ArrayList<>();
//        while (rs.next()) {
//            Availability availability = new Availability("1","1","1","1");
//            availabilities.add(availability);
//        }
//        connection.close();
//        return availabilities;
//    }

    private Availability mapAvailability_ALL(ResultSet rs) throws SQLException {
        Availability availability = new Availability(
                rs.getString(2),
                rs.getString(3),
                rs.getString(4)
        );
        availability.setID(rs.getLong(1));
        return availability;
    }

//    private Availability mapAvailability(ResultSet rs) throws SQLException {
//        Availability availability = new Availability(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
//        availability.setID(rs.getLong(1));
//        availability.setUser_id(rs.getInt(6));
//        return availability;
//    }

    public Availability create(Availability availability) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, availability.getStart_time());
        stm.setString(2, availability.getEnd_time());
        stm.setString(3, availability.getStaff_name());
        stm.executeUpdate();
        ResultSet generatedKeys = stm.getGeneratedKeys();
        if (generatedKeys.next()) {
            availability.setID(generatedKeys.getLong(1));
        } else {
            connection.close();
            throw new SQLException("Creating availability failed, no ID obtained.");
        }
        connection.close();
        return availability;
    }

}
