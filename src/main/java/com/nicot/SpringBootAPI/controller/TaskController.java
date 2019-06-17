package com.nicot.SpringBootAPI.controller;

import com.nicot.SpringBootAPI.model.Task;
import com.nicot.SpringBootAPI.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(path = "/todos", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> allTasks() {
        List<Task> tasks = taskService.getAll();
        return ResponseEntity.ok(tasks);
    }

    @RequestMapping(path = "/todos", method = RequestMethod.POST)
    public ResponseEntity submitTask(@RequestBody Task task) {
        if (!task.isValid()) {
            return ResponseEntity.badRequest().build();
        }

        boolean added = taskService.add(task);
        if (added) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(path = "/todos/{taskId}", method = RequestMethod.PUT)
    public ResponseEntity updateTask(@PathVariable long taskId, @RequestBody Task task) {
        if (!task.isValid()) {
            return ResponseEntity.badRequest().build();
        }

        boolean updated = taskService.update(taskId, task);
        if (updated) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @RequestMapping(path = "/todos/{taskId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable long taskId) {
        boolean deleted = taskService.delete(taskId);

        if (deleted) {
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
