package com.rmarrugo.test.infrastructure.apirest.employee.dto;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class EmployeeResponse {

    Long id;
    String name;

}
