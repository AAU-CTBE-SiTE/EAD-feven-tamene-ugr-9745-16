package com.site;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
@ComponentScan("com.site")
public class AppConfig {

    @Bean("math")
    @Order(1)
    public Subject math() {
        Subject s = new Subject();
        s.setSubjectName("Maths 101");
        return s;
    }

    @Bean("Java")
    @Order(2)
    public Subject java() {
        Subject s = new Subject();
        s.setSubjectName("Java EE");
        return s;
    }
}