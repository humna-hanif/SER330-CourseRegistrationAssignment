package com.ser330.courseregistration;

public class Course {
    private String department;
    private int number;
    private String name;
    private int credits;

    public Course(String department, int number, String name, int credits) {
        this.department = department;
        this.number = number;
        this.name = name;
        this.credits = credits;
    }

    public String toString() {
        return name + ", " + department + " " + number + " (" + credits + " credits)";
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getNumber() {
        return number;
    }

    public int getCredits()
    {
        return credits;
    }
}