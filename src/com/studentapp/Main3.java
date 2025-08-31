package com.studentapp;

import java.util.*;

public class Main3 {

    private static List<Student> studentList;

    public static void main(String args[])
    {
        System.out.println("******* Student Management System ******");
        System.out.println("******* Welcome ******");
        studentList=new ArrayList<>();
        //Read Input from the terminal!!!
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Student name...");
        String name=sc.next();
        System.out.println("You have entered name as "+name);

        System.out.println("Enter Student age...");
        int age=sc.nextInt();
        System.out.println("Studenets age is "+age);

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
