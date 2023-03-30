package com.ser330.courseregistration;

import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Date dateOfBirth = new Date(2023, 3, 30);

        School school = new School("quinnipiac.edu");

        Student student = new Student("Test", "Testerson", school, dateOfBirth, "testUserName");

        Course course = new Course("SoftwareEngineering", 1, "SoftwareQualityAssurance", 3);

        CourseOffering courseOffering = new CourseOffering(course, 1, 2023, "1");
        student.addCourseOffering(courseOffering);

        Instructor instructor = new Instructor("Professor", "Smart", school, dateOfBirth, "ProfessorUserName");

        Institution institution = new Institution("Quinnipiac University", "quinnipiac.edu");
        institution.addCourse(course);
        institution.enrollStudent(student);
        institution.addCourseOffering(courseOffering);
        institution.assignInstructor(instructor, course.getName(), course.getDepartment(), course.getNumber(), 1, 2023, "1");
        

        institution.listCourseSchedule(2023, "1", "SoftwareEngineering");   
    }
}
