package com.ser330.courseregistration;

import java.util.Date;

public class Person {

    protected String lastName; 
    protected String firstName;
    protected String school;
    protected Date dateOfBirth;
    protected String userName;
    protected String affiliation;
    protected String email;

    public Person(String lastName, String firstName, String school, Date dateOfBirth, String userName, String affiliation)
    {
        this.lastName = lastName;
        this.firstName = firstName;
        this.school = school;
        this.dateOfBirth = dateOfBirth;
        this.userName = userName;
        this.affiliation = affiliation;
    }
    
    public String getLastName()
    {
        return this.lastName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getSchool()
    {
        return school;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public String getUserName()
    {
        return userName;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getAffiliation()
    {
        return this.affiliation;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

}
