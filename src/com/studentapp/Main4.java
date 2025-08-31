package com.studentapp;

import java.sql.Struct;
import java.util.*;

import static java.lang.System.exit;

public class Main4 {

    private static List<Student> studentList;
    private static Scanner scanner;

    public static void main(String args[])
    {
        System.out.println("******* Student Management System ******");
        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
        while(true) {
            System.out.println("******* Welcome ******");
            System.out.println("Select an Option...");
            System.out.println("1. Register a Student");
            System.out.println("2. Find student with student id.");
            System.out.println("3. List all student Information.");
            System.out.println("4. List student information in sorted order.");
            System.out.println("5. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    enrollStudent(scanner);
                    break;
                case 2:
                    findStudentById(scanner);
                    break;
                case 3:
                    printAllStudentData();
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    exitFromApp();
                    break;
                default:
                    System.out.println("Invalid option is selected!...Please select option from 1 to 5");
            }
        }


    }

    private static void exitFromApp() {
        System.out.println("Thank you for using application");
        System.exit(0);
    }

    private static void printAllStudentData() {
        if(!studentList.isEmpty()) {
            System.out.println("Print all student data...");
            for (Student student : studentList) {
                student.printStudentInfo();
            }
            System.out.println("*************************");
        }
        else {
            System.err.println("No Student record found!...");
        }
    }

    private static void findStudentById(Scanner scanner) {
        Student studentFound=null;
        System.out.println("Enter students id");
        String studentId=scanner.next();
        try {
            studentFound = studentList.stream()
                    .filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No Data Found !!!"));
        }
        catch (RuntimeException e)
        {
            System.err.println("Student with id "+studentId+" not found!!");
        }
        studentFound.printStudentInfo();
    }

    private static void enrollStudent(Scanner scanner) {
        System.out.println("Enter student name");
        String name= scanner.next();
        System.out.println("Enter student age");
        int studentage= scanner.nextInt();
        System.out.println("Enter student Id");
        String studentId= scanner.next();
        Student student=new Student(name,studentage,studentId);
        studentList.add(student);
        student.printStudentInfo();
        while(true) {
            System.out.println("Enter the course to be enrolled!...Enter Done to exit");
            String course = scanner.next();
            if(course.equalsIgnoreCase("Done"))
            {
                break;
            }
            student.enrollCourse(course);
        }

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
        printAllStudentData();
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
