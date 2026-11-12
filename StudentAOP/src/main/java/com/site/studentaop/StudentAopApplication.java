package com.site.studentaop;

import com.site.studentaop.service.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentAopApplication implements CommandLineRunner {

    private final StudentService studentService;

    // CI
    public StudentAopApplication(StudentService studentService) {
        this.studentService = studentService;
    }

    public static void main(String[] args) {
        SpringApplication.run(StudentAopApplication.class, args);
    }

    @Override
    public void run(String... args) {

        System.out.println("\n...........STUDENT MANAGEMENT SYSTEM...........");

        studentService.addStudent();

        System.out.println("\n.......................................");

        studentService.displayStudent();

        System.out.println("\n........... TEST ERROR HANDLING ...........");

        try {
            studentService.showError();

        } catch (RuntimeException exception) {

            System.out.println("\nMain program caught the error: "+ exception.getMessage());
             }
    }
}
