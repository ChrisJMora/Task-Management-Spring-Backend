package com.api.task_management.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class TaskDTO {
    private Long id;
    private String owner;
    private String project;
    private String issue;
    private String description;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer estimatedDays;
    private long daysDelayed;
}
