package com.nicot.SpringBootAPI.service;

import com.nicot.SpringBootAPI.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAll();

    boolean delete(long taskId);

    boolean add(Task task);

    boolean update(long taskId, Task task);

}
