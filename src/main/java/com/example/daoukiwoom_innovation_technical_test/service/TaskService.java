package com.example.daoukiwoom_innovation_technical_test.service;

import com.example.daoukiwoom_innovation_technical_test.dto.request.TaskQueryRequest;
import com.example.daoukiwoom_innovation_technical_test.dto.request.TaskRequest;
import com.example.daoukiwoom_innovation_technical_test.entity.Employee;
import com.example.daoukiwoom_innovation_technical_test.entity.Task;
import com.example.daoukiwoom_innovation_technical_test.mapper.TaskMapper;
import com.example.daoukiwoom_innovation_technical_test.repository.TaskRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TaskService {
    EmployeeService employeeService;
    TaskRepository taskRepository;
    TaskMapper taskMapper;

    public Task createTask(TaskRequest taskRequest) {
        String employeeId = taskRequest.getEmployeeId();
        Employee employee = employeeService.getEmployeeById(employeeId);
        Task task = taskMapper.toTask(taskRequest);
        task.setEmployee(employee);
        return taskRepository.save(task);
    }

    public List<Task> getTasks(TaskQueryRequest taskQueryRequest) {
        Specification<Task> spec = taskQueryRequest.buildSpecification();
        return taskRepository.findAll(spec);
    }
}
