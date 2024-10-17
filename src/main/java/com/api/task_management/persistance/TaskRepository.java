package com.api.task_management.persistance;

import com.api.task_management.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(String status);
    List<Task> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
}
