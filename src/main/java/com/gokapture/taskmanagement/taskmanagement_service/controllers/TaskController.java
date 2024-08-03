package com.gokapture.taskmanagement.taskmanagement_service.controllers;

import com.gokapture.taskmanagement.taskmanagement_service.models.Task;
import com.gokapture.taskmanagement.taskmanagement_service.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = taskService.getTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long taskId) {
        Optional<Task> task = taskService.getTaskById(taskId);
        return task.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(taskId, task);
        return updatedTask != null ? ResponseEntity.ok(updatedTask)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{taskId}/assign")
    public ResponseEntity<Task> assignTaskToUser(@PathVariable Long taskId, @RequestParam Long userId) {
        Task updatedTask = taskService.assignTaskToUser(taskId, userId);
        return ResponseEntity.ok(updatedTask);
    }
}
