package com.example.daoukiwoom_innovation_technical_test.mapper;

import com.example.daoukiwoom_innovation_technical_test.dto.request.EmployeeRequest;
import com.example.daoukiwoom_innovation_technical_test.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmployeeMapper {
    @Mapping(target = "department", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "username", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateEmployee(@MappingTarget Employee employee, EmployeeRequest employeeRequest);
}
