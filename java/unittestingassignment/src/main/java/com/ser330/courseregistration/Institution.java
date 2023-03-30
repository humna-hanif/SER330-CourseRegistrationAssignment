package com.ser330.courseregistration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Institution {
    String name;
    String domain;
    // key = student username, value = student object
    HashMap<String, Student> studentList; 
    
    // key = course name; value = courses; 
    // institution.coursecatalog[course].add(courseoffering)
   // HashMap<String, ArrayList<CourseOffering>> courseCatalog; 
    HashMap<String, Course> courseCatalog; 
    // key = course name; value = list course offerings
    HashMap<String, ArrayList<CourseOffering>> courseSchedule;

    HashMap<String, Instructor> facultyList; // key = username, value = instructor

    public Institution(String name, String domain) {
        this.name = name;
        this.domain = domain;
        this.studentList = new HashMap<>();
        this.courseCatalog = new HashMap<>();
        this.courseSchedule = new HashMap<>();
        this.facultyList = new HashMap<>();
    }

    public void listStudents() {
        System.out.println('\n' + "Enrolled Students (" + this.name + ")\n" + "-------------------------------------------");
        ArrayList<String> slist = new ArrayList<>();
        for (Student s : this.studentList.values()) {
            slist.add(s.lastName + ", " + s.firstName);
        }
        Collections.sort(slist); //alphabetize
        for (String x : slist) {
            System.out.println(x);
        }
        System.out.println('\n');
    }

    public void enrollStudent(Student student) {
        if (student instanceof Student) {
            if (this.studentList.containsKey(student.username)) {
                System.out.println(student.firstName + " " + student.lastName + " is already enrolled!");
            } else {
                this.studentList.put(student.username, student);
            }
        } else {
            System.out.println("Only accepts student object");
        }
    }

    public void registerStudentForCourse(Student student, String courseName, String dept, String number, String sectionNumber, int year, String quarter) {
        for (CourseOffering offering : this.courseSchedule.get(courseName)) {
            if (dept.equals(offering.getCourse().getDepartment()) && number.equals(offering.getCourse().getNumber()) && year == offering.year && quarter.equals(offering.quarter) && sectionNumber.equals(offering.getSectionNumber())) {
                if (this.studentList.containsValue(student)) { //if student is enrolled in school
                    if (offering.getStudents().contains(student)) { //if student is already enrolled in this offering
                        System.out.println('\n' + student.firstName + " " + student.lastName + " is already enrolled in this course" + '\n');
                    } else {
                        offering.registerStudents(student);
                        System.out.println('\n' + student.firstName + " " + student.lastName + " has been enrolled " + offering.toString() + '\n');
                    }
                }
            }
        }
    }

    public void listInstructors() {
        System.out.println('\n' + "Instructor List (" + this.name + ")\n" + "-------------------------------------------");
        ArrayList<String> flist = new ArrayList<>();
        for (Instructor i : this.facultyList.values()) {
            flist.add(i.lastName + ", " + i.firstName);
        }
        Collections.sort(flist);
        for (String x : flist) {
            System.out.println(x);
        }
        System.out.println('\n');
    }

    public void assignInstructor(Instructor thisInstructor, String courseName, String dept, int number, int sectionNumber, int year, String quarter) {
        for (CourseOffering offering : this.courseSchedule.get(courseName)) {
            if (dept.equals(offering.getCourse().getDepartment()) && number == offering.getCourse().getNumber() && year == offering.getYear() && quarter.equals(offering.getQuarter()) && sectionNumber == offering.getSectionNumber()) {
                if (offering.getInstructor() == thisInstructor) {
                    System.out.println("\n" + thisInstructor.getFirstName() + " " + thisInstructor.getLastName() + " is already teaching this course\n");
                } else {
                    offering.setInstructor(thisInstructor);
                    thisInstructor.addCourseOffering(offering);
                    System.out.println("\n" + thisInstructor.getFirstName() + " " + thisInstructor.getLastName() + " has been assigned to teach " + offering.toString() + "\n");
                }
            } else {
                System.out.println("Course not found. Please create a course and course offering");
            }
        }
    }


/*     public void listCourseCatalog() {
        System.out.println("\nCourse Catalog (" + this.name + ")\n----------------------------------------");
         for (Course course : this.courseCatalog.values().iterator()) {
            System.out.println(course.toString());
         }
        System.out.println("\n");
    } */

    public void listCourseSchedule(int year, String quarter, String dept) {
        List<String> schedule = new ArrayList<>();
        if (dept != null) {
            System.out.println("\n" + "Course Schedule (" + dept + ", " + quarter + " " + year + ") \n" + "----------------------------------------");
            for (List<CourseOffering> offerings : courseSchedule.values()) {
                List<CourseOffering> filtered = new ArrayList<>();
                for (CourseOffering offering : offerings) {
                    if (offering.getYear() == year && offering.getQuarter().equals(quarter) && offering.getCourse().getDepartment().equals(dept)) {
                        filtered.add(offering);
                    }
                }
                for (CourseOffering item : filtered) {
                    schedule.add(item.toString());
                }
            }
        } else {
            System.out.println("\n" + "Course Schedule (" + quarter + " " + year + ") \n" + "----------------------------------------");
            if (!courseSchedule.isEmpty()) {
                for (List<CourseOffering> offerings : courseSchedule.values()) {
                    List<CourseOffering> filtered = new ArrayList<>();
                    for (CourseOffering offering : offerings) {
                        if (offering.getYear() == year && offering.getQuarter().equals(quarter)) {
                            filtered.add(offering);
                        }
                    }
                    for (CourseOffering item : filtered) {
                        schedule.add(item.toString());
                    }
                }
            } else {
                System.out.println("No offerings currently scheduled");
                return;
            }
        }
        if (!schedule.isEmpty()) {
            for (String x : schedule) {
                System.out.println(x);
            }
        } else {
            System.out.println("No offerings during this semester");
        }
    }

    public void listRegisteredStudents(String courseName, String dept, int number, int sectionNumber, int year, String quarter) {
        for (CourseOffering offering : courseSchedule.get(courseName)) {
            if (dept.equals(offering.getCourse().getDepartment()) && number == offering.getCourse().getNumber() && year == offering.getYear() && quarter.equals(offering.getQuarter()) && sectionNumber == offering.getSectionNumber()) {
                System.out.println("Registered Students List (" + offering.toString() + ") \n" + "------------------------------------------------------------");
                for (Student student : offering.getStudents()) {
                    System.out.println(student.getLastName() + ", " + student.getFirstName());
                }
            }
        }
    }

    public void addCourse(Course course) {
        if (course instanceof Course) {
            if (this.courseCatalog.containsKey(course.getName())) {
                System.out.println("Course has already been added");
            } else {
                this.courseCatalog.put(course.getName(), course);
            }
        } else {
            throw new IllegalArgumentException("Only accepts course object as argument");
        }
    }
    public void addCourseOffering(CourseOffering course_offering) {
        if (course_offering instanceof CourseOffering) {
            String courseName = course_offering.getCourse().getName();
            if (this.courseCatalog.containsKey(courseName)) {
                this.courseSchedule.putIfAbsent(courseName, new ArrayList<CourseOffering>());
                List<CourseOffering> offerings = this.courseSchedule.get(courseName);
                offerings.add(course_offering);
            } else {
                System.out.println("Please create a course before creating course offering");
            }
        } else {
            System.out.println("Only accepts course offering as argument");
        }
    }
}