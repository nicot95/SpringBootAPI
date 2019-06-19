package com.nicot.SpringBootAPI.service;

import com.nicot.SpringBootAPI.model.Task;
import com.nicot.SpringBootAPI.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.ArrayList;
import java.util.List;

public class TaskJPAService implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public List<Task> getAll() {
        List<Task> taskList = new ArrayList<>();

        taskRepository.findAll().forEach(task -> taskList.add(task));

        return taskList;
    }

    @Override
    public boolean delete(long taskId) {
        try {
            taskRepository.deleteById(taskId);
        } catch (EmptyResultDataAccessException ex) {
            return false;
        }
        return true;
    }

    @Override
    public boolean add(Task task) {
        taskRepository.save(task);
        return true;
    }

    @Override
    public boolean update(long taskId, Task task) {
        task.setId(taskId);
        taskRepository.save(task);
        return true;
    }
}
