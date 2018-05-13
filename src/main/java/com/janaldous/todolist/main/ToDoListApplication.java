package com.janaldous.todolist.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.janaldous.todolist.repository.StudentJdbcRepository;

@SpringBootApplication
public class ToDoListApplication {
	
	@Autowired
	StudentJdbcRepository repository;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ToDoListApplication.class);
		app.run(args);
		
	}
}