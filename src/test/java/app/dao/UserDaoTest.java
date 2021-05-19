package app.dao;

import app.models.User;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
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
        User user1 = UserDao.INSTANCE.getById((long)2);
        assertNotNull(user1);
        assertEquals("Administrator", user1.getName());
        user1.setName("testName");
        UserDao.INSTANCE.update(user1);
        user1 = UserDao.INSTANCE.getById((long)2);
        assertNotNull(user1);
        assertEquals("testName", user1.getName());
    }
}