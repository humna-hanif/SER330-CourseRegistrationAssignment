
import pytest
from instructor_def import Instructor
from course_def import Course
from course_offering_def import CourseOffering

def test_List_Courses_WhenNoFiltersPresent_ReturnsCompleteList():

    # Arrange
    # Need Instructor
    instructor = Instructor("Last Name", "First Name", "Quinnipiac University", "4/20/2023", "test")
    course = Course("Computer Science", 1234, "Test Class", 3)
    courseOffering1 = CourseOffering(course, "123", "2023", "1")
    courseOffering2 = CourseOffering(course, "123", "2023", "1")
    courseOfferingList = [courseOffering1, courseOffering2]
    instructor.course_list = courseOfferingList

    # Act
    returnedCourses = instructor.list_courses()

    # Assert
    assert len(returnedCourses) == len(courseOfferingList)

def test_List_Courses_WithYearFilter_ReturnsCompleteList():

    # Arrange
    # Need Instructor
    instructor = Instructor("Last Name", "First Name", "Quinnipiac University", "4/20/2023", "test")
    course = Course("Computer Science", 1234, "Test Class", 3)
    courseOffering1 = CourseOffering(course, "123", "2023", "1")
    courseOffering2 = CourseOffering(course, "123", "2023", "1")
    courseOfferingList = [courseOffering1, courseOffering2]
    instructor.course_list = courseOfferingList

    # Act
    #returnedCourses = instructor.list_courses()
    #returnedCourses = instructor.list_courses(quarter=2)
    returnedCourses = instructor.list_courses(year="2023")
    #returnedCourses = instructor.list_courses(year=2023, quarter=1)

    # Assert
    assert len(returnedCourses) == len(courseOfferingList)

def test_List_Courses_WithQuarterFilter_ReturnsCompleteList():

    # Arrange
    # Need Instructor
    instructor = Instructor("Last Name", "First Name", "Quinnipiac University", "4/20/2023", "test")
    course = Course("Computer Science", 1234, "Test Class", 3)
    courseOffering1 = CourseOffering(course, "123", "2023", "1")
    courseOffering2 = CourseOffering(course, "123", "2023", "1")
    courseOfferingList = [courseOffering1, courseOffering2]
    instructor.course_list = courseOfferingList

    # Act
    returnedCourses = instructor.list_courses(quarter="1")

    # Assert
    assert len(returnedCourses) == len(courseOfferingList)

def test_List_Courses_WithQuarterFilter_ReturnsNoData():

        # Arrange
        # Need Instructor
        instructor = Instructor("Last Name", "First Name", "Quinnipiac University", "4/20/2023", "test")
        course = Course("Computer Science", 1234, "Test Class", 3)
        courseOffering1 = CourseOffering(course, "123", "2023", "1")
        courseOffering2 = CourseOffering(course, "123", "2023", "1")
        courseOfferingList = [courseOffering1, courseOffering2]
        instructor.course_list = courseOfferingList

        # Act
        returnedCourses = instructor.list_courses(quarter="2")

        # Assert
        assert len(returnedCourses) == 0