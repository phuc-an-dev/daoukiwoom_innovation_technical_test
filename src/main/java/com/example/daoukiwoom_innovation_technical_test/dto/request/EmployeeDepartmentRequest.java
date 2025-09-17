package com.example.daoukiwoom_innovation_technical_test.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeDepartmentRequest {
    @NotBlank(message = "Employee id must not be blank")
    String employeeId;
    @NotBlank(message = "Department id must not be blank")
    String departmentId;
}
