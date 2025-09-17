package com.example.daoukiwoom_innovation_technical_test.repository;

import com.example.daoukiwoom_innovation_technical_test.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, String> {
    Optional<Department> findByName(String name);

    @Query("SELECT MAX(d.id) FROM Department d")
    Optional<String> findMaxId();
}
