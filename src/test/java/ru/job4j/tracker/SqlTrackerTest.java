package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = new FileInputStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    public void whenReplaceMustBeTheNew() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        Item newItem = new Item("New item");
        tracker.replace(item.getId(),newItem);
        assertThat(tracker.findById(item.getId())).isEqualTo(newItem);
    }

    @Test
    public void whenFindAllCheckFirstItem() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("item 1");
        Item second = new Item("item 2");
        tracker.add(first);
        tracker.add(second);
        Item rsl = tracker.findAll().get(0);
        assertThat(rsl).isEqualTo(first);
    }

    @Test
    public void whenFindByNameCheckFirstItemName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("item 1");
        tracker.add(first);
        assertThat(tracker.findByName(first.getName()).get(0)).isEqualTo(first);
    }

    @Test
    public void whenFindByIdCheckFirstItemId() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("item 1");
        tracker.add(first);
        assertThat(tracker.findById(first.getId())).isEqualTo(first);
    }
}