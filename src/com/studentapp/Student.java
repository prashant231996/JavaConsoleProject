package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    public String getName() {
        return name;
    }

    //instance variables==>instance variable always have to mark with private keyword
    private String name;
    private int age;

    public String getStudentId() {
        return studentId;
    }

    private String studentId;
    private List<String>courses;

    //Constructor==>Constructor basically called while object creation and used to initialize instance variables
    public Student(String name, int age, String studentId) {
        if(validateAge(age) && validateName(name) && validateStudentId(studentId)) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
            courses = new ArrayList<String>(); //Initialize courses
        }
    }

    private boolean validateStudentId(String studentId) {
        //Student Id should starts with S- can contains digit[0-9] + indicates many combinations
        //$ shows end of regix
        String studentIdRegex="S-[0-9]+$";
        Pattern studentIdPattern=Pattern.compile(studentIdRegex);
        Matcher studentIdMatcher=studentIdPattern.matcher(studentId);
        if(studentIdMatcher.matches())
        {
            return true;
        }
        else {
            System.err.println("Invalid Student Id!!!...User format example S-123");
            return false;
        }
    }

    public void enrollCourse(String course)
    {
        if(validateCourseName(course)) {
            if (!courses.contains(course)) {
                courses.add(course);
                System.out.println("Student is enrolled to " + course + " successfully!");
            } else {
                System.err.println("Student already enrolled to this course!!! " + course);
            }
        }
    }

    public void printStudentInfo()
    {
        System.out.println("======== Student Data ========");
        System.out.println("Student name "+name);
        System.out.println("Student age "+age);
        System.out.println("Student Id "+studentId);
        System.out.println("Student Courses "+courses);
    }

    public boolean validateAge(int age)
    {
        if(age>=19 && age<=35)
        {
            return true;
        }
        else {
            System.err.println("Invalid age!!! Student age must be between 19 & 35");
            return false;
        }
    }

    public boolean validateName(String name)
    {
        //prashant ^ this sign indicate that start of string + sign indicate many combination
        //$ regex ends with $ symbol  \\s allowing space in them
        String nameRegex="^[a-zA-Z\\s]+$";
        Pattern namePattern=Pattern.compile(nameRegex);
        Matcher matcher=namePattern.matcher(name);
        if(matcher.matches())
        {
            return true;
        }
        else {
            System.err.println("Invalid name!!! Please enter only alphabets");
            return false;
        }

    }

    public boolean validateCourseName(String course)
    {
        if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("DevOps"))
        {
            return true;
        }
        else {
            System.err.println("Invalid course name!!! Please enter valid course name from the list [Java,DSA,DevOps]");
            return false;
        }
    }






}
