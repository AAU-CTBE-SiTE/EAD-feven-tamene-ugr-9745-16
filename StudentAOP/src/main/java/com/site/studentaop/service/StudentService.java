package com.site.studentaop.service;

import com.site.studentaop.model.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private Student student;

    public void addStudent() {

        student = new Student(
                9745,
                "Feven Tamene",
                "Software Engineering",
                4,
                "Enterprise Applications",
                "A"
        );

        System.out.println("\nStudent added successfully!");

        System.out.println("\nStudent Details:");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Department: " + student.getDepartment());
        System.out.println("Year: " + student.getYear());
        System.out.println("Course: " + student.getCourse());
        System.out.println("Grade: " + student.getGrade());
    }


    public void displayStudent() {

        System.out.println("\nDisplaying Student Information...\n");

        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Department: " + student.getDepartment());
        System.out.println("Year: " + student.getYear());
        System.out.println("Course: " + student.getCourse());
        System.out.println("Grade: " + student.getGrade());
    }

    public void showError() {

        throw new RuntimeException(
                "Student information not found!"
        );
    }
}