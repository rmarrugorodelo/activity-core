package com.rmarrugo.test.infrastructure.apirest.employee.mapper;

import com.rmarrugo.test.domain.employee.Employee;
import com.rmarrugo.test.infrastructure.apirest.employee.dto.EmployeeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeApiRestMapper {

    EmployeeResponse toDto(Employee employee);

}
