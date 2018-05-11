package com.example.demo.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.data.Task;

public class TaskListService {
	private static Map<Integer, Task> tasks;
	private static int ctr = 0;
	
	public static void setTasks() {
		if(tasks == null) {
			tasks = new HashMap<>();
			addTask(new Task("task 0", "description 1"));
			addTask(new Task("task 1", "description 1"));
			addTask(new Task("task 2", "description 2"));
			addTask(new Task("task c", "description c"));
		}
	}
	
	public static List<Task> getTasks() {
		setTasks();
		return new ArrayList<Task>(tasks.values());
	}
	
	public static void addTask(Task task) {
		if (!task.getName().isEmpty()) {
			task.setId(ctr);
			tasks.put(ctr++, task);
		}
	}
	
	public static boolean deleteTask(int id) {
		return tasks.remove(id) != null;
	}

	public static void editTask(int id, Task task) {
		tasks.put(id, task);
	}

	public static Task getTask(int id) {
		return tasks.get(id);
	}
}
