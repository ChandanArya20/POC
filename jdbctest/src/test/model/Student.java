package test.model;

import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private int roll;
    private String city;

    public Student() {
    }

    public Student(int id, String name, int roll, String city) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name) && Objects.equals(roll, student.roll) && Objects.equals(city, student.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, roll, city);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roll=" + roll +
                ", city='" + city + '\'' +
                '}';
    }
}
