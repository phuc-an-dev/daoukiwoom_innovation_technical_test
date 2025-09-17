package com.example.daoukiwoom_innovation_technical_test.service;

import com.example.daoukiwoom_innovation_technical_test.dto.request.LunchLogRequest;
import com.example.daoukiwoom_innovation_technical_test.entity.Employee;
import com.example.daoukiwoom_innovation_technical_test.entity.LunchLog;
import com.example.daoukiwoom_innovation_technical_test.exception.EntityNotFoundException;
import com.example.daoukiwoom_innovation_technical_test.repository.EmployeeRepository;
import com.example.daoukiwoom_innovation_technical_test.repository.LunchLogRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LunchLogService {
    EmployeeRepository employeeRepository;
    LunchLogRepository lunchLogRepository;

    @Transactional
    public List<LunchLog> saveAll(List<LunchLogRequest> requests) {
        List<LunchLog> lunchLogs = requests.stream().map(this::mapToEntity).collect(Collectors.toList());
        return lunchLogRepository.saveAll(lunchLogs);
    }

    private LunchLog mapToEntity(LunchLogRequest req) {
        String employeeId = req.getEmployeeId();
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("Employee not found with id " + employeeId));
        return LunchLog.builder()
                .employee(employee)
                .lunchDate(req.getLunchDate())
                .mealType(req.getMealType())
                .restaurant(req.getRestaurant())
                .notes(req.getNotes())
                .build();
    }
}
