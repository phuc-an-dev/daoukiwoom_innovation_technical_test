package com.example.daoukiwoom_innovation_technical_test.repository;

import com.example.daoukiwoom_innovation_technical_test.dto.TaskCountDto;
import com.example.daoukiwoom_innovation_technical_test.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer>, JpaSpecificationExecutor<Task> {
    List<Task> findByEmployeeId(String employeeId);

    @Query("""
       SELECT new com.example.daoukiwoom_innovation_technical_test.dto.TaskCountDto(t.status, COUNT(t))
       FROM Task t JOIN t.employee e
       WHERE e.department = :departmentId
       GROUP BY t.status
       """)
    List<TaskCountDto> countTasksByStatus(@Param("departmentId") String departmentId);

}
