package com.example.daoukiwoom_innovation_technical_test.repository;

import com.example.daoukiwoom_innovation_technical_test.dto.DepartmentSummaryDto;
import com.example.daoukiwoom_innovation_technical_test.dto.response.DepartmentSalaryResponse;
import com.example.daoukiwoom_innovation_technical_test.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
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

    @Query("""
                SELECT new com.example.daoukiwoom_innovation_technical_test.dto.DepartmentSummaryDto(
                    COUNT(e), COALESCE(AVG(e.salary),0)
                )
                FROM Employee e
                WHERE e.department = :departmentId
            """)
    DepartmentSummaryDto findSalarySummary(@Param("departmentId") String departmentId);

    @Query("SELECT e FROM Employee e WHERE e.department = :departmentId AND e.createdAt >= :fromDate")
    List<Employee> findNewEmployees(@Param("departmentId") String departmentId, @Param("fromDate") LocalDateTime fromDate);
}
