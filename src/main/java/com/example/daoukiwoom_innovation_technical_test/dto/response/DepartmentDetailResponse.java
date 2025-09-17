package com.example.daoukiwoom_innovation_technical_test.dto.response;

import com.example.daoukiwoom_innovation_technical_test.entity.Employee;
import com.example.daoukiwoom_innovation_technical_test.enums.TaskStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentDetailResponse {
    String departmentId;
    String departmentName;
    long totalEmployees;
    double averageSalary;
    Map<TaskStatus, Long> taskCountByStatus;
    List<Employee> newEmployees;
}
