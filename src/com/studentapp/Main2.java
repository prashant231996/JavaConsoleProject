package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {

    private static List<Student> studentList;

    public static void main(String args[])
    {
        System.out.println("******* Student Management System ******");
        System.out.println("******* Welcome ******");
        studentList=new ArrayList<>();
        Student s1;
        s1=new Student("Ravi Nikam",19,"S-1");
        s1.enrollCourse("Java");
        s1.enrollCourse("DevOps");
        s1.enrollCourse("DSA");
        s1.enrollCourse("Java");
        s1.enrollCourse("C#");


        Student s2=new Student("Uday",24,"S-25");
        s2.enrollCourse("Java");


        Student s3=new Student("Ritu",27,"S-30");
        s3.enrollCourse("DevOps");

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);

        Student result=findStudentById("S-30");
        result.printStudentInfo();

        sortByName();


    }

    private static void sortByName() {
        Comparator<Student>comparator=(o1,o2)->o1.getName().compareTo(o2.getName());
           /*     new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };*/
        Collections.sort(studentList,comparator);
        System.out.println(studentList);

    }

    public static Student findStudentById(String studentId)
    {
        Student result=null;
        try {
            result = studentList.stream()
                    .filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No Data Found !!!"));
        }
        catch (RuntimeException e)
        {
            System.err.println("Student with id "+studentId+" not found!!");
        }
        return result;
    }


}
