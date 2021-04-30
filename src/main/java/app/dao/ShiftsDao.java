package app.dao;

import app.models.Shift;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShiftsDao {

    public static ShiftsDao INSTANCE = new ShiftsDao();

    private static String SELECT_ALL = "SELECT * FROM users";
//    private static String SELECT_BY_ID = "SELECT * FROM cinemas WHERE id=?";
    private static String INSERT = "INSERT INTO shifts(date, day, start_time, end_time, staff, position) VALUES(?,?,?,?,?,?)";
//    private static String UPDATE = "UPDATE cinemas SET location = ?, tel = ?  WHERE id=?";
//    private static String REMOVE_CINEMA = "DELETE FROM cinemas WHERE id=?";

    private ShiftsDao(){

    }
//    public List<Shift> getAll() throws SQLException {
//        Shift shift = new Shift("1","1","1","1","1","1");
//        List<Shift> shifts = new ArrayList<>();
//        shifts.add(shift);
//        return shifts;
//    }

    public List<Shift> getAll() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(SELECT_ALL);
        List<Shift> shifts = new ArrayList<>();
        while (rs.next()) {
            Shift shift = new Shift("1","1","1","1",rs.getString(3),"1");
            shifts.add(shift);
        }
        connection.close();
        return shifts;
    }

//    private Shift mapShift(ResultSet rs) throws SQLException {
//        Shift shift = new Shift(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
//        shift.setID(rs.getLong(1));
//        return shift;
//    }

    public Shift create(Shift shift) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, shift.getDate());
        stm.setString(2, shift.getDay());
        stm.setString(3, shift.getStart_time());
        stm.setString(4, shift.getEnd_time());
        stm.setString(5, shift.getStaff());
        stm.setString(6, shift.getPosition());
        stm.executeUpdate();
        ResultSet generatedKeys = stm.getGeneratedKeys();
        if (generatedKeys.next()) {
            shift.setID(generatedKeys.getLong(1));
        } else {
            connection.close();
            throw new SQLException("Creating shift failed, no ID obtained.");
        }
        connection.close();
        return shift;
    }


}
