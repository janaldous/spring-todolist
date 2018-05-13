package com.janaldous.todolist.entity;

import org.hibernate.validator.constraints.NotEmpty;

public class Task {
	private long id;
	@NotEmpty
	private String name;
	private String description;
	private boolean done;
	
	public Task() {
		
	}
	
	public Task(String name, String description) {
		this.setName(name);
		this.setDescription(description);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
	public void toggleDone() {
		done = !done;
	}

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}
}
