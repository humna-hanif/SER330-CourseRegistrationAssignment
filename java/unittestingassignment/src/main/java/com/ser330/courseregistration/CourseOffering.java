package com.ser330.courseregistration;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseOffering {
    private Course course;
    private int sectionNumber;
    private Instructor instructor;
    private int year;
    private String quarter;
    private ArrayList<Student> registeredStudents;
    private HashMap<String, String> grades;

    public CourseOffering(Course course, int sectionNumber, int year, String quarter) {
        this.course = course;
        this.sectionNumber = sectionNumber;
        this.instructor = null;
        this.year = year;
        this.quarter = quarter;
        this.registeredStudents = new ArrayList<>();
        this.grades = new HashMap<>();
    }

    public void register_students(Student... args) {
        for (Student arg : args) {
            this.registeredStudents.add(arg);
            arg.course_list.add(this);
        }
    }

    public ArrayList<Student> get_students() {
        return this.registeredStudents;
    }

    public void submit_grade(Person student, String grade) {
        String[] valid_grades = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"};
        if (student instanceof Student && java.util.Arrays.asList(valid_grades).contains(grade)) {
            this.grades.put(student.getUserName(), grade);
            String key = this.toString();
            student.transcript.put(key, grade);
        } else {
            System.out.println("Please enter a valid grade");
        }
    }

    public String get_grade(Person student) {
        if (student instanceof Student) {
            return this.grades.get(student.username);
        } else {
            return this.grades.get(student);
        }
    }

    public String toString() {
        if (this.instructor != null) {
            return this.course.name + ", " + this.course.department + " " + this.course.number + "-" + this.section_number + ", " + this.instructor.first_name + " " + this.instructor.last_name + " (" + this.quarter + " " + this.year + ")";
        } else {
            return this.course.name + ", " + this.course.department + " " + this.course.number + "-" + this.section_number + " (" + this.quarter + " " + this.year + ")";
        }
    }
}