package com.example.daoukiwoom_innovation_technical_test.controller;

import com.example.daoukiwoom_innovation_technical_test.dto.request.EmployeeDepartmentRequest;
import com.example.daoukiwoom_innovation_technical_test.dto.request.EmployeeRequest;
import com.example.daoukiwoom_innovation_technical_test.dto.response.EmployeeProfileResponse;
import com.example.daoukiwoom_innovation_technical_test.dto.response.SuccessApiResponse;
import com.example.daoukiwoom_innovation_technical_test.entity.Employee;
import com.example.daoukiwoom_innovation_technical_test.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeController {
    EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getEmployee(@PathVariable String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(new SuccessApiResponse<>(employee));
    }

    @PatchMapping
    public ResponseEntity<?> updateEmployee(@Valid  @RequestBody EmployeeRequest employeeRequest) {
        Employee employee = employeeService.updateEmployee(employeeRequest);
        return ResponseEntity.ok(new SuccessApiResponse<>(employee));
    }

    @GetMapping("/profile/{employeeId}")
    public ResponseEntity<?> getEmployeeProfile(@PathVariable String employeeId) {
        EmployeeProfileResponse employeeProfileResponse = employeeService.getEmployeeProfileById(employeeId);
        return ResponseEntity.ok(new SuccessApiResponse<>(employeeProfileResponse));
    }

    @PutMapping("/department")
    public ResponseEntity<?> updateEmployeeDepartment(@Valid @RequestBody EmployeeDepartmentRequest departmentRequest) {
        Employee employee = employeeService.changeEmployeeDepartment(departmentRequest);
        return ResponseEntity.ok(new SuccessApiResponse<>(employee));
    }
}
