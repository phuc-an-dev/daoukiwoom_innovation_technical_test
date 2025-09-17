package com.example.daoukiwoom_innovation_technical_test.entity;

import com.example.daoukiwoom_innovation_technical_test.enums.MealType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "lunch_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LunchLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false, foreignKey = @ForeignKey(name = "fk_lunch_employee"))
    Employee employee;
    @Column(nullable = false)
    LocalDate lunchDate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    MealType mealType;
    String restaurant;
    @Column(columnDefinition = "TEXT")
    String notes;
}
