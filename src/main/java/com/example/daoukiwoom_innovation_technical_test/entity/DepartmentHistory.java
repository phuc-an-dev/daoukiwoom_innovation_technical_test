package com.example.daoukiwoom_innovation_technical_test.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "department_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false, foreignKey = @ForeignKey(name = "fk_employee_id"))
    Employee employee;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "old_department_id", foreignKey = @ForeignKey(name = "fk_old_department"))
    Department oldDepartment;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "new_department_id", nullable = false, foreignKey = @ForeignKey(name = "fk_new_department"))
    Department newDepartment;
    @Column(nullable = false)
    LocalDateTime changeDate;
}
