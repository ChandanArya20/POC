package test.service;

import test.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBSevice {
    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public DBSevice() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql:///jdbctest", "root", "2002ckc+");
        System.out.println("Connection established with DB successfully");
    }

    public List<Student> getAllStudents() {
        var list = new ArrayList<Student>();
        try{
            if(connection!=null){
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
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            closeResources();
        }

        return list;
    }

    public void saveStudents(List<Student> students) {
        try{
            if(connection!=null) {
                statement = connection.prepareStatement("INSERT INTO student (id, name, roll, city) VALUES (?, ?, ?, ?)");
                // Disable auto-commit for batch processing
                connection.setAutoCommit(false);

                // Loop through the student list and add to batch
                for (Student student : students) {
                    statement.setInt(1, student.getId());
                    statement.setString(2, student.getName());
                    statement.setInt(3, student.getRoll());
                    statement.setString(4, student.getCity());

                    // Add this insert to the batch
                    statement.addBatch();
                }

                // Execute the batch
                int[] rowsAffected = statement.executeBatch();
                System.out.println(Arrays.toString(rowsAffected));

                // Commit the transaction
                connection.commit();
                System.out.println("Students insert completed successfully.");
            }
        }catch (Exception e){
            e.printStackTrace();
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
//            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
