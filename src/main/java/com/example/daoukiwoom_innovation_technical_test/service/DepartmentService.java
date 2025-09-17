package com.example.daoukiwoom_innovation_technical_test.service;

import com.example.daoukiwoom_innovation_technical_test.dto.request.DepartmentRequest;
import com.example.daoukiwoom_innovation_technical_test.dto.response.DepartmentSalaryResponse;
import com.example.daoukiwoom_innovation_technical_test.entity.Department;
import com.example.daoukiwoom_innovation_technical_test.exception.ApplicationException;
import com.example.daoukiwoom_innovation_technical_test.repository.DepartmentRepository;
import com.example.daoukiwoom_innovation_technical_test.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentService {
    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department createDepartment(DepartmentRequest departmentRequest) {
        String name = departmentRequest.getName();
        departmentRepository.findByName(name).ifPresent(d -> {
            throw new ApplicationException("This department name is already exists");
        });
        Department department = Department.builder().id(generateDepartmentId()).name(name).build();
        return departmentRepository.save(department);
    }

    public String generateDepartmentId() {
        String lastId = departmentRepository.findMaxId().orElse("dept-000");
        int num = Integer.parseInt(lastId.replace("dept-", ""));
        return String.format("dept-%03d", num + 1);
    }

    public List<DepartmentSalaryResponse> getAverageSalaries() {
        return employeeRepository.findAverageSalaryByDepartment();
    }
}
