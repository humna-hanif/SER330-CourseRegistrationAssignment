import unittest
from datetime import date
from student_def import Student
from course_def import Course
from course_offering_def import CourseOffering

class Test_Student(unittest.TestCase): 
    def test_init(self):
        student = Student("Hanif", "Humna", "Quinnipiac University", "7/20/2002", "hhanif")
        
        student.last_name = "Hanif"
        student.first_name = "Humna"
        student.school = "Quinnipiac University"
        student.date_of_birth = "7/20/2002"
        student.username = "hhanif"
        
        assert student.last_name == "Hanif"
        assert student.first_name == "Humna"
        assert student.school == "Quinnipiac University"
        assert student.date_of_birth == "7/20/2002"
        assert student.username =="hhanif"    
        
    def test_student_list_courses(self):
        student = Student("Hanif", "Humna", "Quinnipiac University", "Jul 20, 2002", "hhanif")
        course = Course("Software Engineering", 341, "Full Stack 2", 3)
        course2 = Course("Biology", 101, "Intro to Biology", 3)
        courseOffering = CourseOffering(course, '1', '2023', 'none')
        courseOffering2 = CourseOffering(course2, '1', '2022', 'none')
        student.transcript = {courseOffering: "A", courseOffering2: "B"}
        
        courseList = Student.list_courses(student)
        assert courseList == [courseOffering, courseOffering2]

        
    def test_student_credits(self):
        student = Student("Hanif", "Humna", "Quinnipiac University", "Jul 20, 2002", "hhanif")
        course = Course("Software Engineering", 341, "Full Stack 2", 3)
        course2 = Course("Biology", 101, "Intro to Biology", 3)
        courseOffering = CourseOffering(course, '1', '2023', 'none')
        courseOffering2 = CourseOffering(course2, '1', '2022', 'none')
        
        student.course_list = [courseOffering, courseOffering2]
        assert student.credits == 6
        
    def test_gpa(self):
        student = Student("Hanif", "Humna", "Quinnipiac University", "Jul 20, 2002", "hhanif")
        course = Course("Software Engineering", 341, "Full Stack 2", 3)
        courseOffering = CourseOffering(course, '1', '2023', 'none')
        courseOffering.register_students([student])
      
        courseOffering.submit_grade(student, "A")
        
        self.assertEqual(student.gpa, 4.0)
 



    def test_list_courses(self):
       student1 = Student('Hanif', 'Humna', 'Quinnipiac University', '7/20/2002', 'hhanif')

       course = Course("Software Engineering", 341, "Full Stack 2", 3)

       student1.course_list.append(course)
       
       student1.transcript[course] = 'A'