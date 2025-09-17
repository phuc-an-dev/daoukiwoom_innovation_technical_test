package com.example.daoukiwoom_innovation_technical_test.repository;

import com.example.daoukiwoom_innovation_technical_test.dto.response.DepartmentSalaryResponse;
import com.example.daoukiwoom_innovation_technical_test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query("""
            SELECT new com.example.daoukiwoom_innovation_technical_test.dto.response.DepartmentSalaryResponse(
                 d.name, AVG(e.salary)
            )
            FROM Employee e
            JOIN Department d ON e.department = d.id
            GROUP BY d.name
            """)
    List<DepartmentSalaryResponse> findAverageSalaryByDepartment();
}
