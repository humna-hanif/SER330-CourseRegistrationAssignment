package com.ser330.courseregistration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void VerifyPersonCreated_WhenAllConditionsMet_ReturnsObject()
    {
        // Arrange
        School school = new School("quinnipiac.edu");
        Date dateOfBirth = new Date();
        Person person = new Person("Nicolini", "Dylan", school, dateOfBirth, "DylanNicolini", "Faculty");
        String emailAddress = "Dylan.Nicolini@Quinnipiac.edu";
        
        // Act
        // Invoke property setting behavior
        person.setFirstName("Test");

        // Assert
        // Verify the object was created successfully
        assertNotNull(person);

        // Verify that the email address was updated correctly
        //assertEquals(emailAddress, person.getEmail());

        // Additional assertion to verify the email address is not blank - Example only
        assertNotEquals("", person.getEmail());
    }

    @Test
    public void VerifyPersonLastNameRetrieved_WhenAllConditionsMet_ReturnsString()
    {
        // Arrange
        School school = new School("quinnipiac.edu");
        Date dateOfBirth = new Date();
        Person person = new Person("Nicolini", "Dylan", school, dateOfBirth, "DylanNicolini", "Faculty");

        
        // Act
        // Invoke property setting behavior
        String lastName = person.getLastName();

        // Assert
        // Verify that the email address was updated correctly
        assertEquals("Nicolini", lastName);
    }
}
