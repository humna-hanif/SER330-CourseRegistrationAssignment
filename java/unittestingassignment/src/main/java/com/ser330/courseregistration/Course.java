package com.ser330.courseregistration;
public class Course {
    
    protected String department;
    protected String number; 
    protected String name;
    protected int credits;
    protected String year;
    protected String quarter;

    public Course(String department, String number, String name, int credits, String year, String quarter)
    {
        this.department = department;
        this.number = number;
        this.name = name;
        this.credits = credits;
        this.year = year;
        this.quarter = quarter;

    }
    
    public String ToString()
    {
        return this.department + " " + this.number + " " + this.name + " " + String.valueOf(credits);
    }

    public int getCredits()
    {
        return this.credits;
    }

    public String getYear()
    {
        return year;
    }

    public String getQuarter()
    {
        return quarter;
    }
}
