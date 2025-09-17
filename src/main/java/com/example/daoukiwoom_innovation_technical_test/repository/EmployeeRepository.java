package com.example.daoukiwoom_innovation_technical_test.repository;

import com.example.daoukiwoom_innovation_technical_test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}
