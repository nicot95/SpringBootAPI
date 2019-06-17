package com.nicot.SpringBootAPI.service;

import com.nicot.SpringBootAPI.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskServiceImpl implements TaskService {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    private static final String GET_ALL_TASKS_SQL = "SELECT * FROM tasks";
    private static final String INSERT_TASK_SQL = "INSERT INTO tasks(id, description, done) VALUES (:id, :description, :done)";
    private static final String UPDATE_TASK_SQL = "UPDATE tasks SET id = :id, description = :description, done = :done WHERE id = :taskId";
    private static final String DELETE_TASK_SQL = "DELETE FROM tasks WHERE id = :id";


    public List<Task> getAll() {
        List<Task> taskList = new ArrayList<>();
        jdbcTemplate.query(GET_ALL_TASKS_SQL,
                rs -> {
                    Task task = new Task(
                            rs.getInt("ID"),
                            rs.getString("Description"),
                            rs.getBoolean("Done"));
                    taskList.add(task);
        });
        return taskList;
    }

    public boolean add(Task task) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", task.getId());
        paramMap.put("description", task.getDescription());
        paramMap.put("done", task.isDone());

        int inserted;
        try {
             inserted = jdbcTemplate.update(INSERT_TASK_SQL, paramMap);
        } catch (DataAccessException ex) {
            inserted = 0;
        }

        return inserted == 1;
    }

    public boolean update(long taskId, Task task) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("taskId", taskId);
        paramMap.put("id", task.getId());
        paramMap.put("description", task.getDescription());
        paramMap.put("done", task.isDone());

        int updated;
        try {
            updated = jdbcTemplate.update(UPDATE_TASK_SQL, paramMap);
        } catch (DataAccessException ex) {
            updated = 0;
        }

        return updated == 1;
    }

    public boolean delete(long taskId) {
        Map<String, Long> paramMap = new HashMap<>();
        paramMap.put("id", taskId);

        int deletedRows = jdbcTemplate.update(DELETE_TASK_SQL, paramMap);

        return deletedRows == 1;
    }
}
