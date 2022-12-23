package com.ibm.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RequestMapping
public class CourseApplication {
	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);
		System.out.println("Hello world");
	}
}
