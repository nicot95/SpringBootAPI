package com.nicot.SpringBootAPI.repository;

import com.nicot.SpringBootAPI.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
