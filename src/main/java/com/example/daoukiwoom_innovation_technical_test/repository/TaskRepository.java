package com.example.daoukiwoom_innovation_technical_test.repository;

import com.example.daoukiwoom_innovation_technical_test.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findByEmployeeId(String employeeId);
}
