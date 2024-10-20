package test.service;

import test.model.Student;

import java.util.List;

public interface DBService {
    public List<Student> getAllStudents();
    public void saveStudents(List<Student> students);
}
