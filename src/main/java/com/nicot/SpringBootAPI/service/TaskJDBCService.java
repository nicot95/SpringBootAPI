package com.nicot.SpringBootAPI.service;

import com.nicot.SpringBootAPI.model.Task;
import com.nicot.SpringBootAPI.repository.TaskJDBCRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskJDBCService implements TaskService {

    @Autowired
    private TaskJDBCRepository taskJDBCRepository;


    public List<Task> getAll() {
        return taskJDBCRepository.getAll();
    }

    public boolean add(Task task) {
        return taskJDBCRepository.add(task);
    }

    public boolean update(long taskId, Task task) {
        return taskJDBCRepository.update(taskId, task);
    }

    public boolean delete(long taskId) {
        return taskJDBCRepository.delete(taskId);
    }
}
