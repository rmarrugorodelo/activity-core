package com.rmarrugo.test.infrastructure.persistence.employee.mapper;

import com.rmarrugo.test.domain.employee.Employee;
import com.rmarrugo.test.infrastructure.persistence.employee.entity.EmployeeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeePersitenceMapper {

    EmployeeEntity toEntity(Employee employee);

    Employee toDomain(EmployeeEntity employee);

}
