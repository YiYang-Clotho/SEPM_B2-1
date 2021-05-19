package app.dao;

import app.models.Shift;
import app.models.User;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ShiftsDaoTest {
    @BeforeEach
    void setup(){
        //Use a different DB for testing
        String DB = "jdbc:h2:file:./target/shift_systemtest";
        //Set the environment property so that DBUtils point to the same file DB.
        System.setProperty(DBUtils.DB_URL,DB);
        //Get Flyway instance
        Flyway flyway = Flyway.configure().dataSource(DB, "sa","").load();
        //Clean testing DB before each test to make sure we have a consistent state
        flyway.clean();
        //Set up db
        flyway.migrate();
    }

    @Test
    public void update() throws SQLException {
        Shift shift1 = ShiftsDao.INSTANCE.getByID((long) 1);
        assertNotNull(shift1);
        assertEquals("test shift 1", shift1.getTitle());
        shift1.setTitle("change title");
        ShiftsDao.INSTANCE.update(shift1);
        shift1 = ShiftsDao.INSTANCE.getByID((long) 1);
        assertNotNull(shift1);
        assertEquals("change title", shift1.getTitle());
    }
}