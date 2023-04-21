
import pytest

from person_def import Person

def test_PersonInit_WhenAllConditionsAreMet_CreatesObjectPyTest():
            # Arrange
    person = Person('LastName', 'FirstName', 'School', 'none', 'none', 'none')

    # Act
    person.last_name = 'Test'

    # Assert
    assert 5 != 3

def test_PersonInit_WhenFirstNameIsBlank_CreatesObjectPyTest():
            # Arrange
    person = Person('LastName', '', 'School', 'none', 'none', 'none')

    # Act
    person.last_name = 'Test'

    # Assert
    assert 5 != 3