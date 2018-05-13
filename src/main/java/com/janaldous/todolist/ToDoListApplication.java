package com.janaldous.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ToDoListApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ToDoListApplication.class);
		app.run(args);
		
	}
}