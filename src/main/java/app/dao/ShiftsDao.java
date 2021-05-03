package app.dao;

import app.models.Shift;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShiftsDao {

    public static ShiftsDao INSTANCE = new ShiftsDao();

    private static String SELECT_ALL = "SELECT * FROM shifts";
    //    private static String SELECT_BY_ID = "SELECT * FROM cinemas WHERE id=?";
    private static String INSERT = "INSERT INTO shifts(title, staff_name, detail, status, created_time, finish_time, due_time) VALUES(?,?,?,?,?,?,?)";
//    private static String UPDATE = "UPDATE cinemas SET location = ?, tel = ?  WHERE id=?";
//    private static String REMOVE_CINEMA = "DELETE FROM cinemas WHERE id=?";

    private ShiftsDao(){

    }

    public List<Shift> getAll() throws SQLException {
        Connection connection = DBUtils.getConnection();
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(SELECT_ALL);
        List<Shift> shifts = new ArrayList<>();
        while (rs.next()) {
            shifts.add(mapShift_ALL(rs));
        }
        connection.close();
        return shifts;
    }

    public Shift create(Shift shift) throws SQLException {
        Connection connection = DBUtils.getConnection();
        PreparedStatement stm = connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, shift.getTitle());
        stm.setString(2, shift.getStaff_name());
        stm.setString(3, shift.getDetail());
        stm.setString(4, shift.getStatus());
        stm.setString(5, shift.getCreated_time());
        stm.setString(6, shift.getFinish_time());
        stm.setString(7, shift.getDue_time());
        stm.executeUpdate();
        ResultSet generatedKeys = stm.getGeneratedKeys();
        if (generatedKeys.next()) {
            shift.setId(generatedKeys.getLong(1));
        } else {
            connection.close();
            throw new SQLException("Creating shift failed.");
        }
        connection.close();
        return shift;
    }

    private Shift mapShift_ALL(ResultSet rs) throws SQLException {
        Shift shift = new Shift(rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5),
                rs.getString(6),
                rs.getString(7),
            rs.getString(8));
        shift.setId(rs.getLong(1));
        return shift;
    }

}
