package com.example.daoukiwoom_innovation_technical_test.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DepartmentSalaryResponse {
    String departmentName;
    Double averageSalary;
}
