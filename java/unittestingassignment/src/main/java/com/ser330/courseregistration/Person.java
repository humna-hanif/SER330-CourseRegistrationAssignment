package com.ser330.courseregistration;

import java.util.Date;

public class Person {
    protected String lastName;
    protected String firstName;
    protected School school;
    protected Date dateOfBirth;
    protected String username;
    protected String affiliation;

    public Person(String lastName, String firstName, School school, Date dateOfBirth, String username, String affiliation) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.school = school;
        this.dateOfBirth = dateOfBirth;
        this.username = username;
        this.affiliation = affiliation;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public School getSchool()
    {
        return school;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public String getUserName()
    {
        return username;
    }

    public String getAffiliation()
    {
        return affiliation;
    }
    public String getEmail() {
        return username + '@' + school.getDomain();
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
}