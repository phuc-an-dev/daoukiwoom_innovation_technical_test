package com.example.daoukiwoom_innovation_technical_test.controller;

import com.example.daoukiwoom_innovation_technical_test.dto.request.DepartmentRequest;
import com.example.daoukiwoom_innovation_technical_test.dto.response.DepartmentSalaryResponse;
import com.example.daoukiwoom_innovation_technical_test.dto.response.SuccessApiResponse;
import com.example.daoukiwoom_innovation_technical_test.entity.Department;
import com.example.daoukiwoom_innovation_technical_test.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentController {
    DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<?> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(new SuccessApiResponse<>(departments));
    }

    @PostMapping
    public ResponseEntity<?> createDepartment(@Valid @RequestBody DepartmentRequest departmentRequest) {
        Department department = departmentService.createDepartment(departmentRequest);
        return ResponseEntity.ok(new SuccessApiResponse<>(department));
    }

    @GetMapping("/average-salary")
    public ResponseEntity<?> getAverageSalaries() {
        List<DepartmentSalaryResponse> departmentSalaryResponseList = departmentService.getAverageSalaries();
        return ResponseEntity.ok(new SuccessApiResponse<>(departmentSalaryResponseList));
    }
}
