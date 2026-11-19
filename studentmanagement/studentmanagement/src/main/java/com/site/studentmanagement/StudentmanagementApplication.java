package com.site.studentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // this combine 3 major annotation @Configuration,@EnableAutoConfiguration,@ComponentScan
public class StudentmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementApplication.class, args);//This starts the Spring Boot application.
	}

}
