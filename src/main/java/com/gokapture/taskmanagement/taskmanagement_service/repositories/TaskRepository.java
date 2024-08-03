package com.gokapture.taskmanagement.taskmanagement_service.repositories;

import com.gokapture.taskmanagement.taskmanagement_service.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
