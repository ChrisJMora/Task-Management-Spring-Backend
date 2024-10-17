package com.api.task_management.service;

import com.api.task_management.model.DateRange;
import com.api.task_management.model.WrappedEntity;
import com.api.task_management.model.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    WrappedEntity<List<TaskDTO>> getAllTasks();
    WrappedEntity<List<TaskDTO>> getDelayedTasksByDateRange(DateRange dateRange);
}
