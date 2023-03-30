package com.ser330.courseregistration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

public class Student extends Person {
    
    ArrayList<CourseOffering> courseList;
    HashMap<String, String> transcript;

    public Student(String last_name, String first_name, School school, Date date_of_birth, String username) {
        super(last_name, first_name, school, date_of_birth, username, "student");
        courseList = new ArrayList<CourseOffering>();
        transcript = new HashMap<String, String>();
    }

    public ArrayList<CourseOffering> list_courses() {
       return courseList;
    }

    public int credits() {
        int total = 0;
        for (CourseOffering offering : courseList) {
            total += offering.getCourse().getCredits();
        }
        return total;
    }

    public double gpa() {
        double earned = 0;
        double available = 0;

        HashMap<String, Double> grade_scale = new HashMap<String, Double>();
        grade_scale.put("A+", 4.0);
        grade_scale.put("A", 4.0);
        grade_scale.put("A-", 3.67);
        grade_scale.put("B+", 3.33);
        grade_scale.put("B", 3.0);
        grade_scale.put("B-", 2.67);
        grade_scale.put("C+", 2.33);
        grade_scale.put("C", 2.0);
        grade_scale.put("C-", 1.67);
        grade_scale.put("D+", 1.33);
        grade_scale.put("D", 1.0);
        grade_scale.put("D-", 0.67);
        grade_scale.put("F", 0.0);

        for (CourseOffering offering : courseList) {
            String grade = offering.getGrade(this);
            if (grade != null) {
                earned += (grade_scale.get(grade) * offering.getCourse().getCredits());
                available += offering.getCourse().getCredits();
            }
        }

        double gpa;
        if (available == 0) {
            gpa = 0;
        } else {
            gpa = earned / available;
        }

        return gpa;
    }

    public String toString() {
        return ("\n" + "Student Name: " + firstName + " " + lastName + "\n" +
            "School: " + school + "\n" +
            "DOB: " + dateOfBirth.toString() + "\n" +
            "Username: " + username + "\n" +
            "Email: " +  getEmail() + "\n" +
            "GPA: " + gpa() + "\n" +
            "Credits: " + credits() + "\n");
    }

    class CourseOfferingComparator implements Comparator<CourseOffering> {
        public int compare(CourseOffering c1, CourseOffering c2) {
            int year_compare = Integer.compare(c2.year, c1.year);
            if (year_compare != 0) {
                return year_compare;
            } else {
                return c2.quarter.compareTo(c1.quarter);
            }
        }
    }

    public void addCourseOffering(CourseOffering courseOffering) 
    {
        courseList.add(courseOffering);
    }

    public String getUsername() 
    {
        return username;
    }

    public void addGrade(String key, String grade) 
    {
        transcript.put(key, grade);
    }
}
