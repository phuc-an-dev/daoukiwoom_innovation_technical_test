package com.example.daoukiwoom_innovation_technical_test.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequest {
    @NotBlank(message = "Employee id is required")
    String id;
    @Size(max = 100, message = "Fullname must not exceed 100 characters")
    String fullname;
    @Size(max = 50, message = "Position must not exceed 50 characters")
    String position;
    @Min(value = 0, message = "Salary must be greater than or equal to 0")
    Integer salary;
}
