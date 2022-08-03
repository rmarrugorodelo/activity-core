package com.rmarrugo.test.infrastructure.persistence.employee.adapter;

import com.rmarrugo.test.domain.employee.Employee;
import com.rmarrugo.test.domain.employee.port.EmployeeFinderRepository;
import com.rmarrugo.test.infrastructure.persistence.employee.repository.EmployeeJpaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class EmployeeAdapter implements EmployeeFinderRepository {

    private final EmployeeJpaRepository jpaRepository;
    private final ModelMapper mapper;

    @Override
    public List<Employee> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(employee -> mapper.map(employee, Employee.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return jpaRepository.findById(id)
                .map(employee -> mapper.map(employee, Employee.class));
    }

}
