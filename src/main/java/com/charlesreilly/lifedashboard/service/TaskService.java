package com.charlesreilly.lifedashboard.service;

import com.charlesreilly.lifedashboard.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks(Long userId);
    Task getTaskById(Long taskId);

    Task createTask(Task task);

    Task updateTask(Long taskId, Task task);

    void deleteTask(Long taskId);
}
