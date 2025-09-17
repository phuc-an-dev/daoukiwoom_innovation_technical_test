package com.example.daoukiwoom_innovation_technical_test.service;

import com.example.daoukiwoom_innovation_technical_test.entity.Department;
import com.example.daoukiwoom_innovation_technical_test.entity.DepartmentHistory;
import com.example.daoukiwoom_innovation_technical_test.entity.Employee;
import com.example.daoukiwoom_innovation_technical_test.repository.DepartmentHistoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentHistoryService {
    DepartmentHistoryRepository departmentHistoryRepository;

    public void recordChange(Employee employee, Department oldDept, Department newDept) {
        DepartmentHistory history = DepartmentHistory.builder()
                .employee(employee)
                .oldDepartment(oldDept)
                .newDepartment(newDept)
                .changeDate(LocalDateTime.now())
                .build();
        departmentHistoryRepository.save(history);
    }
}
