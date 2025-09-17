package com.example.daoukiwoom_innovation_technical_test.dto.request;

import com.example.daoukiwoom_innovation_technical_test.enums.TaskStatus;
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
public class TaskRequest {
    @NotBlank(message = "Employee ID must not be blank")
    String employeeId;
    @NotBlank(message = "Task name must not be blank")
    @Size(max = 100, message = "Task name must be at most 100 characters")
    String taskName;
    @Size(max = 500, message = "Description must be at most 500 characters")
    String description;
    TaskStatus status = TaskStatus.TO_DO;
}
