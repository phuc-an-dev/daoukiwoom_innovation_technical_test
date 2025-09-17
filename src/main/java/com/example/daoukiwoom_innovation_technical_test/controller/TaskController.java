package com.example.daoukiwoom_innovation_technical_test.controller;

import com.example.daoukiwoom_innovation_technical_test.dto.request.TaskRequest;
import com.example.daoukiwoom_innovation_technical_test.dto.response.SuccessApiResponse;
import com.example.daoukiwoom_innovation_technical_test.entity.Task;
import com.example.daoukiwoom_innovation_technical_test.service.TaskService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskController {
    TaskService taskService;

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody TaskRequest taskRequest) {
        Task task = taskService.createTask(taskRequest);
        return ResponseEntity.ok(new SuccessApiResponse<>(task));
    }
}
