package com.example.weblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class WeblogApplication {
    public static void main(String[] args) {
        SpringApplication.run(WeblogApplication.class, args);
    }
}
