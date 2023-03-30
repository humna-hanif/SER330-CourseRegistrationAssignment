package com.ser330.courseregistration;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseOffering {
    private Course course;
    private int sectionNumber;
    private Instructor instructor;
    int year;
    String quarter;
    private ArrayList<Student> registeredStudents;
    private HashMap<String, String> grades;

    public CourseOffering(Course course, int section_number, int year, String quarter) {
        this.course = course;
        this.sectionNumber = section_number;
        this.instructor = null;
        this.year = year;
        this.quarter = quarter;
        this.registeredStudents = new ArrayList<Student>();
        this.grades = new HashMap<String, String>();
    }

    public void registerStudents(Student... students) {
        for (Student student : students) {
            this.registeredStudents.add(student);
            student.addCourseOffering(this);
        }
    }

    public ArrayList<Student> getStudents() {
        return this.registeredStudents;
    }

    public void submitGrade(Student student, String grade) {
        String[] valid_grades = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};
        boolean is_valid_grade = false;
        for (String valid_grade : valid_grades) {
            if (grade.equals(valid_grade)) {
                is_valid_grade = true;
                break;
            }
        }
        if (student instanceof Student && is_valid_grade) {
            this.grades.put(student.getUsername(), grade);
            String key = this.toString();
            student.addGrade(key, grade);
        } else {
            System.out.println("Please enter a valid grade");
        }
    }

    public String getGrade(Student student) {
        if (student instanceof Student) {
            return this.grades.get(student.getUsername());
        } else {
            throw new IllegalArgumentException("Invalid argument");
        }
    }
    public Course getCourse() {
        return course;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public int getYear() {
        return year;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public HashMap<String, String> getGrades() {
        return grades;
    }

    public String getYearAsString()
    {
        return String.valueOf(year);
    }
    
    public String toString() {
        if (this.instructor != null) {
            return this.course.getName() + ", " + this.course.getDepartment() + " " + this.course.getNumber() + "-" +
                    this.sectionNumber + ", " + this.instructor.getFirstName() + " " + this.instructor.getLastName() +
                    " (" + this.quarter + " " + this.year + ")";
        } else {
            return this.course.getName() + ", " + this.course.getDepartment() + " " + this.course.getNumber() + "-" +
                    this.sectionNumber + " (" + this.quarter + " " + this.year + ")";
        }
    }


}