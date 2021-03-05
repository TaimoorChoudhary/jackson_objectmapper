package model;

import java.util.StringJoiner;

/**
 * @author Taimoor Choudhary
 */
public class Course {
    private String name;
    private double credits;

    public Course() {
    }

    public Course(String name, double credits) {
        this.name = name;
        this.credits = credits;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Course.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("credits=" + credits)
                .toString();
    }
}
