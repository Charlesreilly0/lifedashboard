package com.charlesreilly.lifedashboard.service.impl;

import com.charlesreilly.lifedashboard.model.Task;
import com.charlesreilly.lifedashboard.repository.TaskRepository;
import com.charlesreilly.lifedashboard.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Override
    public List<Task> getAllTasks(Long userId) {
        return taskRepository.findByUserId(userId);
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long taskId, Task task) {
        Optional<Task> existingTask = taskRepository.findById(taskId);
        if(existingTask.isPresent()){
            task.setId(taskId);
            return taskRepository.save(task);
        }
        return null;
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
