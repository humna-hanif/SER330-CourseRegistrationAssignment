
import pytest

from person_def import Person
from institution_def import Institution
from course_def import Course
from course_offering_def import CourseOffering
from student_def import Student

def test_VerifyRegisterStudenForCourse_WhenAllConditionsMet():

    
    # Arrange
    # Define a course and a course offering
    #
    department = "ComputerScience"
    courseNumber = 1234
    courseName = "TestClass"
    courseCredits = 3
    courseSectionNumber = 123
    courseOfferYear = 2023
    courseQuarter = 1
    course = Course(department=department, number=courseNumber, name=courseName, credits= courseCredits)
    courseOffering = CourseOffering(course, courseSectionNumber, courseOfferYear, courseQuarter)

    # Define a student
    student1 = Student("Test", "Test", "School Test", "4/20/2023", "test")

    # Define an institution
    institution = Institution("Quinnipiac University", "qu.edu")

    #Add the course to the institution (to the course catalog)
    institution.add_course(course)

    # Add the course to to the planned course offerings
    institution.add_course_offering(courseOffering)

    # Enroll the student into the school
    institution.enroll_student(student1)

    courseSchedule = institution.course_schedule
    # Act
    # Register the student for the course
    institution.register_student_for_course(student1, courseName, department, courseNumber, courseSectionNumber, courseOfferYear, courseQuarter)

    # Assert
    assert len(courseOffering.registered_students) == 1

