package com.example.daoukiwoom_innovation_technical_test.service;

import com.example.daoukiwoom_innovation_technical_test.dto.DepartmentSummaryDto;
import com.example.daoukiwoom_innovation_technical_test.dto.TaskCountDto;
import com.example.daoukiwoom_innovation_technical_test.dto.request.DepartmentRequest;
import com.example.daoukiwoom_innovation_technical_test.dto.response.DepartmentDetailResponse;
import com.example.daoukiwoom_innovation_technical_test.dto.response.DepartmentSalaryResponse;
import com.example.daoukiwoom_innovation_technical_test.entity.Department;
import com.example.daoukiwoom_innovation_technical_test.entity.Employee;
import com.example.daoukiwoom_innovation_technical_test.enums.TaskStatus;
import com.example.daoukiwoom_innovation_technical_test.exception.ApplicationException;
import com.example.daoukiwoom_innovation_technical_test.exception.EntityNotFoundException;
import com.example.daoukiwoom_innovation_technical_test.repository.DepartmentRepository;
import com.example.daoukiwoom_innovation_technical_test.repository.EmployeeRepository;
import com.example.daoukiwoom_innovation_technical_test.repository.TaskRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentService {
    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;
    TaskRepository taskRepository;

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

    public DepartmentDetailResponse getDepartmentDetail(String departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + departmentId));
        String departmentName = department.getName();
        // 1. Total & avg salary
        DepartmentSummaryDto departmentSummary = employeeRepository.findSalarySummary(departmentId);
        long totalEmployees = departmentSummary.getTotalEmployees();
        // If there are no employees, return a default response immediately
        if (totalEmployees == 0) {
            return DepartmentDetailResponse.builder()
                    .departmentId(departmentId)
                    .departmentName(departmentName)
                    .totalEmployees(0)
                    .averageSalary(0)
                    .taskCountByStatus(new HashMap<>())
                    .newEmployees(new ArrayList<>())
                    .build();
        }
        // 2. Count task by status
        List<TaskCountDto> taskCounts = taskRepository.countTasksByStatus(departmentId);
        Map<TaskStatus, Long> taskCountMap = new HashMap<>();
        for (TaskCountDto taskCountResponse : taskCounts) {
            taskCountMap.put(taskCountResponse.getStatus(), taskCountResponse.getCount());
        }
        // 3. New employee last 30 days
        LocalDateTime fromDate = LocalDateTime.now().minusDays(30);
        List<Employee> newEmployees = employeeRepository.findNewEmployees(departmentId, fromDate);
        // 4. Return
        return DepartmentDetailResponse.builder()
                .departmentId(departmentId)
                .departmentName(departmentName)
                .totalEmployees(departmentSummary.getTotalEmployees())
                .averageSalary(departmentSummary.getAverageSalary())
                .taskCountByStatus(taskCountMap)
                .newEmployees(newEmployees)
                .build();
    }
}
