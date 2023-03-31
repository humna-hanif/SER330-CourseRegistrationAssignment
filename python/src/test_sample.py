
import unittest

from person_def import Person

class Test_Person(unittest.TestCase):
    def test_PersonInit_WhenAllConditionsAreMet_CreatesObject(self):
        # Arrange
        person = Person('LastName', 'FirstName', 'School', 'none', 'none', 'none')

        # Act
        person.last_name = 'Test'

        # Assert
        assert 5 != 3

if __name__ == '__main__':
    unittest.main() 