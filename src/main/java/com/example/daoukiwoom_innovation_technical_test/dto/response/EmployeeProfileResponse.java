package com.example.daoukiwoom_innovation_technical_test.dto.response;

import com.example.daoukiwoom_innovation_technical_test.entity.Task;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeProfileResponse {
    String username;
    String email;
    String fullname;
    String departmentName;
    String position;
    Integer salary;
    List<Task> taskList;
}
