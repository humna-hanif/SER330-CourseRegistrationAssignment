
import unittest

from course_offering_def import CourseOffering
from course_def import Course
from student_def import Student
from institution_def import Institution

# Example of test cases using the Unit Test Framework 
# A class must exist and the unitTest.TestCase is passed as a parameter
# Test Methods can exist outside of a class
# Test methods must accept the self parameter


class TestCourseOffering(unittest.TestCase):
    # Note the test method here has a _UnitTest Suffix - This is not required and purely for demonstration purposes
    # Note: the self paramater MUST be passed
    
    def test_VerifyGradeSubmission_WhenAllConditionsAreMet_ReturnsTrue_UnitTest(self):
    
        # Arrange
        course = Course("Computer Science", 1234, "Test Class", 3)
        cc = CourseOffering(course, "123", "2023", "1")
        student1 = Student("Test", "Test", "School Test", "4/20/2023", "userName")
        studentsList = [student1]
        

        # Act
        #cc.register_students(studentsList)
        cc.submit_grade(student1, 'B')

        # Assert
        # Grades is a dictionary not a list
        # Grades are stored in the dictionary by user name
        # Given this we can test for multiple conditions

        # does 1 and only 1 grade exist?
        assert len(cc.grades) == 1
        
        # Is the key of the grade the username for student 1?
        assert cc.grades.keys().__contains__("userName")
        
        #Is the value of this grade a B?
        assert cc.grades.get("userName") == 'B'