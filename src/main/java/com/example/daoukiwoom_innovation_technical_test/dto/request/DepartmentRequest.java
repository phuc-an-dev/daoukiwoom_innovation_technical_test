package com.example.daoukiwoom_innovation_technical_test.dto.request;

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
public class DepartmentRequest {
    @NotBlank(message = "Department name must not be blank")
    @Size(max = 100, message = "Department name must be at most 100 characters")
    String name;
}
