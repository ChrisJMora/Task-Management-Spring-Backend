package com.api.task_management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DateRange {
    private LocalDate startDate;
    private LocalDate endDate;
}
