package com.ser330.courseregistration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void VerifyPersonCreated_WhenAllConditionsMet_ReturnsObject()
    {
        // Arrange
        Person person = new Person("Nicolini", "Dylan", "Quinnipiac University", "SomeDate", "DylanNicolini", "Faculty");
        String emailAddress = "Dylan.Nicolini@Quinnipiac.edu";
        
        // Act
        // Invoke property setting behavior
        person.setEmail(emailAddress);

        // Assert
        // Verify the object was created successfully
        assertNotNull(person);

        // Verify that the email address was updated correctly
        // assertEquals(emailAddress, person.getEmail());

        // Additional assertion to verify the email address is not blank - Example only
        // assertNotEquals("", person.getEmail());
    }
}
