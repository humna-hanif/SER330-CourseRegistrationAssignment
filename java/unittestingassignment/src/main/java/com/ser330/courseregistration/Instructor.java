package com.ser330.courseregistration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Instructor extends Person {
    private List<CourseOffering> courseList;

    public Instructor(String lastName, String firstName, School school, Date dateOfBirth, String username) {
        super(lastName, firstName, school, dateOfBirth, username, "instructor");
        this.courseList = new ArrayList<>();
    }

    public List<String> listCourses(Integer year, String quarter) {
        List<CourseOffering> filtered = new ArrayList<>();
        for (CourseOffering o : courseList) {
            if ((year == null || o.getYearAsString().toString().equals(String.valueOf(year)))
                    && (quarter == null || o.getQuarter().equals(quarter))) {
                filtered.add(o);
            }
        }
        Collections.sort(filtered, new OfferingComparator());
        List<String> result = new ArrayList<>();
        for (CourseOffering o : filtered) {
            result.add(o.toString());
        }
        return result;
    }

    public List<CourseOffering> getCourseList()
    {
        return courseList;
    }

    public void addCourseOffering(CourseOffering courseOffering)
    {
        courseList.add(courseOffering);
    }
    @Override
    public String toString() {
        return ("\n" + "Instructor Name: " + this.getFirstName() + " " + this.getLastName() + "\n" +
                "School: " + this.getSchool().getName() + "\n" +
                "DOB: " + this.getDateOfBirth().toString() + "\n" +
                "Username: " + this.getUserName() + "\n");
    }

    private class OfferingComparator implements java.util.Comparator<CourseOffering> {
        @Override
        public int compare(CourseOffering o1, CourseOffering o2) {

            int yearCompare = o2.getYearAsString().compareTo(o1.getYearAsString());
            if (yearCompare != 0) {
                return yearCompare;
            } else {
                return o2.getQuarter().compareTo(o1.getQuarter());
            }
        }
    }
}