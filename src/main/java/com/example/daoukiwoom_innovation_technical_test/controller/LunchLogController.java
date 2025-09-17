package com.example.daoukiwoom_innovation_technical_test.controller;

import com.example.daoukiwoom_innovation_technical_test.dto.request.LunchLogRequest;
import com.example.daoukiwoom_innovation_technical_test.dto.response.SuccessApiResponse;
import com.example.daoukiwoom_innovation_technical_test.entity.LunchLog;
import com.example.daoukiwoom_innovation_technical_test.service.LunchLogService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/lunch-logs")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LunchLogController {
    private final LunchLogService lunchLogService;

    @PostMapping
    public ResponseEntity<?> createLunchLogs(@RequestBody List<LunchLogRequest> requests) {
        List<LunchLog> savedLogs = lunchLogService.saveAll(requests);
        return ResponseEntity.ok(new SuccessApiResponse<>(savedLogs));
    }
}
