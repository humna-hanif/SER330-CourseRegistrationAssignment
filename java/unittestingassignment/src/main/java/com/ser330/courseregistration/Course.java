package com.ser330.courseregistration;
public class Course {
    
    String department;
    String number; 
    String name;
    int credits;
    public Course(String department, String number, String name, int credits)
    {
        this.department = department;
        this.number = number;
        this.name = name;
        this.credits = credits;

    }
    
    public String ToString()
    {
        return this.department + " " + this.number + " " + this.name + " " + String.valueOf(credits);
    }
}
