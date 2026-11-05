package com.site;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.List;

@Data
@ToString
@Component
public class Student {
    private int id;
    private String name;
    private int age;
    private Address address;
    private List<Subject> subjects;

    public Student(@Value("101") int id,
                   @Value("Feven Temene") String name,
                   @Value("20") int age,
                   Address address,
                   List<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.subjects = subjects;
    }

    public void getDetails() {
        System.out.println("Student Name: " + this.getName());
        int index = 1;
        for (Subject subject : subjects) {
            System.out.println("Subject " + index + ": " + subject.getSubjectName());
            index++;
        }
    }
}