package model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.StringJoiner;

/**
 * @author Taimoor Choudhary
 */
public class Student extends Person {

    private int year;
    private String department;
    private List<Course> courses;

    @JsonCreator
    public Student(@JsonProperty("year")int year, @JsonProperty("department")String department) {
        this.year = year;
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add(super.toString())
                .add("year=" + year)
                .add("department='" + department + "'")
                .add("courses=" + courses)
                .toString();
    }
}
