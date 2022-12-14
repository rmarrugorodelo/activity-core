package com.rmarrugo.test.infrastructure.apirest.employee.controller;

import com.rmarrugo.test.domain.employee.port.EmployeeFinder;
import com.rmarrugo.test.infrastructure.apirest.employee.dto.EmployeeResponse;
import com.rmarrugo.test.infrastructure.apirest.employee.mapper.EmployeeApiRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/employees")
public class EmployeeFinderController {

    private final EmployeeFinder employeeFinder;
    private final EmployeeApiRestMapper mapper;

    @GetMapping
    public List<EmployeeResponse> findAll() {
        return employeeFinder.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

}
