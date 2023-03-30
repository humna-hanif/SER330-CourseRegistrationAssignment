package com.ser330.courseregistration;

import java.util.ArrayList;
import java.util.List;

public class Student {
    
    Person person;
    int credits;
    double gpa;
    List<Course> courseList;
    List<String> transcript;

    public Student (String lastName, String firstName, String school, String dateOfBirth, String userName)
    {   this.person = new Person(lastName, firstName, school, dateOfBirth, userName, "student");
        this.courseList = new ArrayList<Course>();
        this.transcript = new ArrayList<String>();
    }

    public int getCredits()
    {
        int total = 0;
        for (Course course : courseList) {
            total = total + course.credits;
        }

        return total;
    }
}
