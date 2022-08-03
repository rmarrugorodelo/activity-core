package com.rmarrugo.test.application.employee;

import com.rmarrugo.test.domain.employee.Employee;
import com.rmarrugo.test.domain.employee.port.EmployeeFinder;
import com.rmarrugo.test.domain.employee.port.EmployeeFinderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeFinderUseCase implements EmployeeFinder {

    private final EmployeeFinderRepository finderRepository;

    @Override
    public List<Employee> findAll() {
        return finderRepository.findAll();
    }

}
