package com.gokapture.taskmanagement.taskmanagement_service.services;

import com.gokapture.taskmanagement.taskmanagement_service.models.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getTasks();
    Optional<Task> getTaskById(Long id);
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);
    Task assignTaskToUser(Long taskId, Long userId);
}
