package com.example.daoukiwoom_innovation_technical_test.controller;

import com.example.daoukiwoom_innovation_technical_test.dto.request.TaskQueryRequest;
import com.example.daoukiwoom_innovation_technical_test.dto.request.TaskRequest;
import com.example.daoukiwoom_innovation_technical_test.dto.response.SuccessApiResponse;
import com.example.daoukiwoom_innovation_technical_test.entity.Task;
import com.example.daoukiwoom_innovation_technical_test.enums.TaskStatus;
import com.example.daoukiwoom_innovation_technical_test.service.TaskService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskController {
    TaskService taskService;

    @PostMapping
    public ResponseEntity<?> createTask(@Valid @RequestBody TaskRequest taskRequest) {
        Task task = taskService.createTask(taskRequest);
        return ResponseEntity.ok(new SuccessApiResponse<>(task));
    }

    @GetMapping
    public ResponseEntity<?> getTasks(@RequestParam(value = "employee_id", required = false) String employeeId,
                                      @RequestParam(value = "status", required = false) TaskStatus status,
                                      @RequestParam(value = "due_date", required = false) String dueDate) {
        TaskQueryRequest taskQueryRequest = new TaskQueryRequest(employeeId, status, dueDate);
        List<Task> tasks = taskService.getTasks(taskQueryRequest);
        return ResponseEntity.ok(new SuccessApiResponse<>(tasks));
    }

    @PutMapping("/{id}/assign")
    public Task assignTask(@PathVariable("id") Integer taskId,
                           @RequestParam("assignee_id") String assigneeId,
                           @RequestParam("assigned_by") String assignedById ) {
        return taskService.assignTask(taskId, assigneeId, assignedById);
    }
}
