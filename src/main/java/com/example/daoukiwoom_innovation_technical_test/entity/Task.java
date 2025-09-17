package com.example.daoukiwoom_innovation_technical_test.entity;

import com.example.daoukiwoom_innovation_technical_test.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Task extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false, foreignKey = @ForeignKey(name = "fk_tasks_employee"))
    @JsonIgnore
    Employee employee;
    @Column(nullable = false)
    String taskName;
    @Column(columnDefinition = "TEXT")
    String description;
    LocalDate dueDate;
    @Column(nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    TaskStatus status;
    String assignedBy;
}
