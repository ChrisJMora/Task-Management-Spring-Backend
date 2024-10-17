package com.api.task_management.controller;

import com.api.task_management.model.ApiResult;
import com.api.task_management.model.DateRange;
import com.api.task_management.model.Error;
import com.api.task_management.service.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@CrossOrigin(origins = "https://task-management-demo-example.netlify.app/")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskServiceImp taskServiceImp;

    @GetMapping("/all")
    public ResponseEntity<ApiResult> getAllTasks() {
        try {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(taskServiceImp.getAllTasks());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Error(e.getMessage()));
        }
    }

    @PostMapping("/delayed")
    public ResponseEntity<ApiResult> getAllDelayedTasks(@RequestBody DateRange dateRange) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND)
                    .body(taskServiceImp.getDelayedTasksByDateRange(dateRange));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new Error(e.getMessage()));
        }
    }
}
