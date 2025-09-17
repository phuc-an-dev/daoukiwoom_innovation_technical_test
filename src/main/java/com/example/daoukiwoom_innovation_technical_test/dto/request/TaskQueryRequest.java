package com.example.daoukiwoom_innovation_technical_test.dto.request;

import com.example.daoukiwoom_innovation_technical_test.entity.Task;
import com.example.daoukiwoom_innovation_technical_test.enums.TaskStatus;
import com.example.daoukiwoom_innovation_technical_test.exception.ApplicationException;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskQueryRequest {
    String employeeId;
    TaskStatus status;
    String dueDate;

    public Specification<Task> buildSpecification() {
        List<Specification<Task>> specs = new ArrayList<>();
        if (!StringUtils.hasText(employeeId)) {
            throw new ApplicationException("Employee ID must not be empty");
        }
        specs.add((root, query, cb) -> cb.equal(root.get("employee").get("id"), employeeId));
        if (status != null) {
            specs.add((root, query, cb) -> cb.equal(root.get("status"), status));
        }
        if (StringUtils.hasText(dueDate)) {
            LocalDate parsedDate = LocalDate.parse(dueDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            specs.add((root, query, cb) -> cb.equal(root.get("dueDate"), parsedDate));
        }
        return Specification.allOf(specs);
    }
}
