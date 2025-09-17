package com.example.daoukiwoom_innovation_technical_test.dto.request;

import com.example.daoukiwoom_innovation_technical_test.enums.MealType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LunchLogRequest {
    @NotNull(message = "Employee ID must not be null")
    String employeeId;
    @NotNull(message = "Lunch date must not be null")
    LocalDate lunchDate;
    @NotNull(message = "Meal type must not be null")
    MealType mealType;
    @NotBlank(message = "Restaurant must not be blank")
    String restaurant;
    String notes;
}
