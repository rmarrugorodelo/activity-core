package com.rmarrugo.test.domain.employee.port;

import com.rmarrugo.test.domain.employee.Employee;

import java.util.List;

public interface EmployeeFinder {

    List<Employee> findAll();

}
