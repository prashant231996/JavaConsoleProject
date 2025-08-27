package com.studentapp;

import java.util.ArrayList;
import java.util.List;

public class Student {

    //instance variables==>instance variable always have to mark with private keyword
    private String name;
    private int age;
    private String studentId;
    private List<String>courses;

    //Constructor==>Constructor basically called while object creation and used to initialize instance variables
    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        courses=new ArrayList<String>(); //Initialize courses
    }

    public void enrollCourse(String course)
    {
        courses.add(course);
        System.out.println("Student is enrolled to "+course+" successfully!");
    }

    public void printStudentInfo()
    {
        System.out.println("======== Student Data ========");
        System.out.println("Student name "+name);
        System.out.println("Student age "+age);
        System.out.println("Student Id "+studentId);
        System.out.println("Student Courses "+courses);
    }



}
