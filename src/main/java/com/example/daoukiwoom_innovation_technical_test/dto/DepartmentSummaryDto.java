package com.example.daoukiwoom_innovation_technical_test.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentSummaryDto {
    long totalEmployees;
    double averageSalary;
}
