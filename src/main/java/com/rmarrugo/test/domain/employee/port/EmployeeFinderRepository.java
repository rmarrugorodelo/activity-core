package com.rmarrugo.test.domain.employee.port;

import com.rmarrugo.test.domain.employee.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeFinderRepository {

    List<Employee> findAll();

    Optional<Employee> findById(Long id);

}
