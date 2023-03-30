package com.ser330.courseregistration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Instructor extends Person {
    private List<Course> courseList;

    public Instructor(String lastName, String firstName, String school, Date dateOfBirth, String username) {
        super(lastName, firstName, school, dateOfBirth, username, "instructor");
        this.courseList = new ArrayList<>();
    }

    public List<String> listCourses(Integer year, Integer quarter) {
        if (year != null && quarter != null) { //filter by year and quarter
            List<Course> filtered = new ArrayList<>();
            for (Course course : courseList) {
                if (course.getYear().equals(year) && course.getQuarter().equals(quarter)) {
                    filtered.add(course);
                }
            }
            Collections.sort(filtered, new Comparator<Course>() {
                public int compare(Course a, Course b) {
                    int result = b.getYear().compareTo(a.getYear());
                    if (result == 0) {
                        result = b.getQuarter().compareTo(a.getQuarter());
                    }
                    return result;
                }
            });
            List<String> finalList = new ArrayList<>();
            for (Course course : filtered) {
                finalList.add(course.toString());
            }
            return finalList;
        } else if (year != null) { //only year arg given
            List<Course> filtered = new ArrayList<>();
            for (Course course : courseList) {
                if (course.getYear().equals(year)) {
                    filtered.add(course);
                }
            }
            Collections.sort(filtered, new Comparator<Course>() {
                public int compare(Course a, Course b) {
                    int result = b.getYear().compareTo(a.getYear());
                    if (result == 0) {
                        result = b.getQuarter().compareTo(a.getQuarter());
                    }
                    return result;
                }
            });
            List<String> finalList = new ArrayList<>();
            for (Course course : filtered) {
                finalList.add(course.toString());
            }
            return finalList;
        } else if (quarter != null) { //only quarter arg given
            List<Course> filtered = new ArrayList<>();
            for (Course course : courseList) {
                if (course.getQuarter().equals(quarter)) {
                    filtered.add(course);
                }
            }
            Collections.sort(filtered, new Comparator<Course>() {
                public int compare(Course a, Course b) {
                    int result = b.getYear().compareTo(a.getYear());
                    if (result == 0) {
                        result = b.getQuarter().compareTo(a.getQuarter());
                    }
                    return result;
                }
            });
            List<String> finalList = new ArrayList<>();
            for (Course course : filtered) {
                finalList.add(course.toString());
            }
            return finalList;
        } else { //no filters given, default to None
            Collections.sort(courseList, new Comparator<Course>() {
                public int compare(Course a, Course b) {
                    int result = b.getYear().compareTo(a.getYear());
                    if (result == 0) {
                        result = b.getQuarter().compareTo(a.getQuarter());
                    }
                    return result;
                }
            });
            List<String> finalList = new ArrayList<>();
            for (Course course : courseList) {
                finalList.add(course.toString());
            }
            return finalList;
        }
    }

    public String toString() {
        return ("\n" + "Instructor Name: " + this.getFirstName() + " " + this.getLastName() + "\n" +
            "School: " + this.getSchool().getName() + "\n" +
            "DOB: " +
    }
}