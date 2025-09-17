package com.example.daoukiwoom_innovation_technical_test.dto;

import com.example.daoukiwoom_innovation_technical_test.enums.TaskStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskCountDto {
    TaskStatus status;
    long count;
}
