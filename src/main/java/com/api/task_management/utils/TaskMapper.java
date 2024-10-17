package com.api.task_management.utils;

import com.api.task_management.model.Employee;
import com.api.task_management.model.Project;
import com.api.task_management.model.Task;
import com.api.task_management.model.dto.TaskDTO;

public class TaskMapper {

    public static TaskDTO mapToDto(Task task) {
        if (task == null) {
            return null; // Handle null case
        }
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(task.getId());
        taskDTO.setIssue(task.getIssue());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setStartDate(task.getStartDate());
        taskDTO.setEndDate(task.getEndDate());
        taskDTO.setEstimatedDays(task.getEstimatedDays());
        taskDTO.setDaysDelayed(task.getDaysDelayed());

        Employee employee = task.getEmployee();
        if (employee != null) {
            taskDTO.setOwner(employee.getFirstName() + " " + employee.getLastName());
        }
        Project project = task.getProject();
        if (project != null) {
            taskDTO.setProject(project.getName());
        }

        return taskDTO;
    }
}
