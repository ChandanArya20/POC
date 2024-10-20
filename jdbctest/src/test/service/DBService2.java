package test.service;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import test.model.Student;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBService2 implements DBService{
    private DataSource dataSource;
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public DBService2() {
        // Configure HikariCP
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql:///jdbctest");
        config.setUsername("root");
        config.setPassword("2002ckc+");

        // Optional HikariCP configurations (for tuning)
        config.setMaximumPoolSize(10); // Set the max number of connections in the pool
        config.setMinimumIdle(2);      // Minimum number of idle connections
        config.setIdleTimeout(60000);  // Connection idle timeout in milliseconds

        // Initialize the DataSource with HikariCP
        dataSource = new HikariDataSource(config);
    }

    public List<Student> getAllStudents() {
        var list = new ArrayList<Student>();
        try {
            connection = dataSource.getConnection();
            if (connection != null) {
                statement = connection.prepareStatement("SELECT * FROM student");
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int roll = resultSet.getInt("roll");
                    String city = resultSet.getString("city");

                    Student student = new Student(id, name, roll, city);
                    list.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return list;
    }

    public void saveStudents(List<Student> students) {
        try {
            connection = dataSource.getConnection();
            if (connection != null) {
                statement = connection.prepareStatement("INSERT INTO student (id, name, roll, city) VALUES (?, ?, ?, ?)");
                connection.setAutoCommit(false); // Disable auto-commit for batch processing

                // Loop through the student list and add to batch
                for (Student student : students) {
                    statement.setInt(1, student.getId());
                    statement.setString(2, student.getName());
                    statement.setInt(3, student.getRoll());
                    statement.setString(4, student.getCity());
                    statement.addBatch();
                }

                int[] rowsAffected = statement.executeBatch(); // Execute the batch
                System.out.println(Arrays.toString(rowsAffected));

                connection.commit(); // Commit the transaction
                System.out.println("Students insert completed successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback(); // Rollback in case of failure
                    System.out.println("Transaction rolled back.");
                }
            } catch (SQLException rollbackException) {
                rollbackException.printStackTrace();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true); // Reset auto-commit to true
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            closeResources();
        }
    }

    // Utility method for closing resources
    private void closeResources() {
        try {
            if (resultSet != null) resultSet.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

