package com.api.task_management.service;

import com.api.task_management.model.DateRange;
import com.api.task_management.model.Task;
import com.api.task_management.model.WrappedEntity;
import com.api.task_management.model.dto.TaskDTO;
import com.api.task_management.persistance.TaskRepository;
import com.api.task_management.utils.TaskMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImp implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public WrappedEntity<List<TaskDTO>> getAllTasks() {
        return new WrappedEntity<>(taskRepository.findAll().stream()
                .map(TaskMapper::mapToDto)
                .toList());
    }

    @Override
    public WrappedEntity<List<TaskDTO>> getDelayedTasksByDateRange(DateRange dateRange) {
        // Filter all the tasks within the date range
        List<Task> tasks = getTasksByDateRange(dateRange);
        return new WrappedEntity<>(tasks.stream()
                .filter(Task::isNotCompleted)
                .filter(Task::isInTime)
                .map(TaskMapper::mapToDto)
                .toList());
    }

    private List<Task> getTasksByDateRange(DateRange dateRange) {
        return taskRepository.findByStartDateBetween(dateRange.getStartDate(),
                dateRange.getEndDate());
    }
}
