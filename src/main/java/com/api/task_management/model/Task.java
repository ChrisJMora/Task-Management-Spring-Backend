package com.api.task_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;

    @Column(name = "task_issue")
    private String issue;
    @Column(name = "task_description")
    private String description;
    @Column(name = "task_status")
    private String status;
    @Column(name = "task_start_date", columnDefinition = "DATE")
    private LocalDate startDate;
    @Column(name = "task_estimated_days")
    private Integer estimatedDays;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @OneToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @Transient
    private LocalDate endDate;
    @Transient
    private long daysDelayed;

    public LocalDate getEndDate() {
        return this.getStartDate().plusDays(getEstimatedDays());
    }

    public long getDaysDelayed() {
        if (isInTime() && isNotCompleted()) {
            return ChronoUnit.DAYS.between(getEndDate(), LocalDate.now());
        }
        return 0;
    }

    public boolean isInTime() {
        return getEndDate().isBefore(LocalDate.now());
    }

    public boolean isNotCompleted() {
        return !getStatus().equals("FINALIZADO");
    }
}
