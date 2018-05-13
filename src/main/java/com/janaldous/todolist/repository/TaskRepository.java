package com.janaldous.todolist.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.janaldous.todolist.entity.Task;

@Repository
public class TaskRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class TaskRowMapper implements RowMapper<Task> {
		@Override
		public Task mapRow(ResultSet rs, int rowNum) throws SQLException {
			Task task = new Task();
			task.setId(rs.getLong("id"));
			task.setName(rs.getString("name"));
			task.setDescription(rs.getString("description"));
			task.setDone(rs.getBoolean("done"));
			return task;
		}

	}

	public List<Task> findAll() {
		return jdbcTemplate.query("select * from task", new TaskRowMapper());
	}

	public Task findById(long id) {
		return jdbcTemplate.queryForObject("select * from task where id=?", new Object[] { id },
				new BeanPropertyRowMapper<Task>(Task.class));
	}

	public int deleteById(long id) {
		return jdbcTemplate.update("delete from task where id=?", new Object[] { id });
	}

	public int insert(Task task) {
		return jdbcTemplate.update("insert into task (name, description, done) " + "values(?, ?, ?)",
				new Object[] { task.getName(), task.getDescription(), task.isDone() });
	}

	public int update(Task task) {
		return jdbcTemplate.update("update task " + " set name = ?, description = ?, done = ?" + " where id = ?",
				new Object[] { task.getName(), task.getDescription(), task.isDone(), task.getId() });
	}
	
	public int markDone(long id, boolean done) {
		return jdbcTemplate.update("update task set done = ? where id = ?",
				new Object[] { done, id });
	}
}
