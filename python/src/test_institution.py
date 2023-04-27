import unittest
import pytest
from institution_def import Institution
from instructor_def import Instructor
from course_def import Course
from course_offering_def import CourseOffering
from student_def import Student

class Test_Institution(unittest.TestCase): 
    def test_init(self):
        institution = Institution("Quinnipiac University", "quinnipiac.edu")
        institution.name = "Quinnipiac University"
        institution.domain = "quinnipiac.edu"
        
        assert institution.name == "Quinnipiac University"
        assert institution.domain == "quinnipiac.edu"

    def test_list_students(self):
        studentList = ["Humna", "Julia", "Jacob", "Bob"]
        self.assertIsInstance(studentList, list)
    
    def test_list_instructors(self):
        instructorList = ["Boomer", "Nicolini", "Duncan"]
        self.assertIsInstance(instructorList, list)

    def test_enroll_students(self):
        institution = Institution("Quinnipiac University", "quinnipiac.edu")
        student1 = Student('Hanif', 'Humna', 'Quinnipiac University', '7/20/2002', 'hhanif')
        institution.enroll_student(student1)
        institution.list_students() 
        
        assert institution.student_list.get("hhanif") == student1



    def test_hire_instructor(self):
        institution = Institution("Quinnipiac University", "quinnipiac.edu")
        instructor = Instructor("Boomer", "Bobcat", "Quinnipiac University", "June 15, 1999", "bboomer")
        institution.hire_instructor(instructor)

        assert institution.faculty_list.get("bboomer") == instructor
        
    def test_add_course(self):
        institution = Institution("Quinnipiac University", "quinnipiac.edu")
        course = Course("Software Engineering", 341, "Full Stack 2", 3)
        institution.add_course(course)
        
        assert institution.course_catalog.get("Full Stack 2") == course

    def test_add_course_offering(self):
        institution = Institution("Quinnipiac University", "quinnipiac.edu")
        course = Course("Software Engineering", 341, "Full Stack 2", 3)
        courseOffering = CourseOffering(course, '1', '2023', 'none')
        institution.add_course(course)
        institution.add_course_offering(courseOffering)
        institution.list_course_schedule(institution, "2023", "none")
        
        assert len(institution.course_schedule) == 1

    def test_register_student_forCourse(self):
        department = "Software Engineering"
        courseNumber = 341
        courseName = "Full Stack 2"
        courseCredits = 3
        courseSectionNumber = 101
        courseOfferYear = 2023
        courseQuarter = 1
        course = Course(department=department, number=courseNumber, name=courseName, credits= courseCredits)
        courseOffering = CourseOffering(course, courseSectionNumber, courseOfferYear, courseQuarter)
        student1 = Student("Test", "Test", "School Test", "4/26/2023", "test")
        institution = Institution("Quinnipiac University", "quinnipiac.edu")
        institution.add_course(course)
        institution.add_course_offering(courseOffering) 
        institution.enroll_student(student1)
        courseSchedule = institution.course_schedule
        institution.register_student_for_course(student1, courseName, department, courseNumber, courseSectionNumber, courseOfferYear, courseQuarter)
        
        assert len(courseOffering.registered_students) == 1