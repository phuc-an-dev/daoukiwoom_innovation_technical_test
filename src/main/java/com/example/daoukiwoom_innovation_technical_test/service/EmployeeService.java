package com.example.daoukiwoom_innovation_technical_test.service;

import com.example.daoukiwoom_innovation_technical_test.dto.request.EmployeeRequest;
import com.example.daoukiwoom_innovation_technical_test.entity.Employee;
import com.example.daoukiwoom_innovation_technical_test.exception.EntityNotFoundException;
import com.example.daoukiwoom_innovation_technical_test.mapper.EmployeeMapper;
import com.example.daoukiwoom_innovation_technical_test.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmployeeService {
    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;

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
}
