import test.model.Student;
import test.service.DBSevice;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        DBSevice dbSevice = new DBSevice();
        var allStudents = dbSevice.getAllStudents();
        System.out.println(allStudents);

        var students = new ArrayList<Student>();

        // Adding sample students
        students.add(new Student(1, "John Doe", 101, "New York"));
        students.add(new Student(2, "Jane Smith", 102, "Los Angeles"));
        students.add(new Student(3, "Mike Brown", 103, "Chicago"));
        students.add(new Student(4, "Emily Davis", 104, "Houston"));
        students.add(new Student(5, "David Wilson", 105, "Phoenix"));

        dbSevice.saveStudents(students);
    }
}