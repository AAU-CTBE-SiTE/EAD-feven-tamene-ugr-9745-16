package com.site;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {

    private int id;
    private String name;
    private int age;
    private Address address;


    public void getDetails() {
        System.out.println("Student Details: " + this);
    }
}
