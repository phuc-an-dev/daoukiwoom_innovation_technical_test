package com.example.daoukiwoom_innovation_technical_test.service;

import com.example.daoukiwoom_innovation_technical_test.dto.request.EmployeeRequest;
import com.example.daoukiwoom_innovation_technical_test.dto.response.EmployeeProfileResponse;
import com.example.daoukiwoom_innovation_technical_test.entity.Department;
import com.example.daoukiwoom_innovation_technical_test.entity.Employee;
import com.example.daoukiwoom_innovation_technical_test.entity.Task;
import com.example.daoukiwoom_innovation_technical_test.exception.EntityNotFoundException;
import com.example.daoukiwoom_innovation_technical_test.mapper.EmployeeMapper;
import com.example.daoukiwoom_innovation_technical_test.repository.DepartmentRepository;
import com.example.daoukiwoom_innovation_technical_test.repository.EmployeeRepository;
import com.example.daoukiwoom_innovation_technical_test.repository.TaskRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService {
    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;
    DepartmentRepository departmentRepository;
    TaskRepository taskRepository;

    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + id));
    }

    public Employee updateEmployee(EmployeeRequest employeeRequest) {
        String id = employeeRequest.getId();
        Employee employee = getEmployeeById(id);
        employeeMapper.updateEmployee(employee, employeeRequest);
        employee = employeeRepository.save(employee);
        return employee;
    }

    public EmployeeProfileResponse getEmployeeProfileById(String id) {
        // To EmployeeProfileResponse
        Employee employee = getEmployeeById(id);
        EmployeeProfileResponse employeeProfileResponse = employeeMapper.toEmployeeProfileResponse(employee);
        // Set department name
        String departmentId = employee.getDepartment();
        Department department = departmentRepository.findById(departmentId).orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + departmentId));
        String departmentName = department.getName();
        employeeProfileResponse.setDepartmentName(departmentName);
        // Set employee list task
        List<Task> employeeTaskList = taskRepository.findByEmployeeId(employee.getId());
        employeeProfileResponse.setTaskList(employeeTaskList);
        return employeeProfileResponse;
    }
}
