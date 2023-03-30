package com.ser330.courseregistration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String dateInString = "30-Mar-2023";
        Date dateOfBirth = formatter.parse(dateInString);

        School school = new School("quinnipiac.edu");

        Student student = new Student("Test", "Testerson", school, dateOfBirth, "testUserName");

        Course course = new Course("SoftwareEngineering", 1, "SoftwareQualityAssurance", 3);

        CourseOffering courseOffering = new CourseOffering(course, 1, 2023, "1");
        student.addCourseOffering(courseOffering);

        Instructor instructor = new Instructor("Professor", "Smart", school, dateOfBirth, "ProfessorUserName");

    }
}
