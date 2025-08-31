package com.studentapp;

public class Main {

    public static void main(String args[])
    {
        System.out.println("******* Student Management System ******");
        System.out.println("******* Welcome ******");

        Student s1;
        s1=new Student("Ravi Nikam",19,"S-1");
        s1.enrollCourse("Java");
        s1.enrollCourse("DevOps");
        s1.enrollCourse("DSA");
        s1.enrollCourse("Java");
        s1.enrollCourse("C#");
        s1.printStudentInfo();

        Student s2=new Student("Uday",24,"S-25");
        s2.enrollCourse("Java");
        s2.printStudentInfo();

        Student s3=new Student("Ritu",27,"S-30");
        s3.enrollCourse("DevOps");
        s3.printStudentInfo();


    }

}
