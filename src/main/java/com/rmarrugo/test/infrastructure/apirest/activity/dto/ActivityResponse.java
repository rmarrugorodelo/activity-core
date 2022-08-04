package com.rmarrugo.test.infrastructure.apirest.activity.dto;

import com.rmarrugo.test.infrastructure.apirest.employee.dto.EmployeeResponse;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Builder
@Value
public class ActivityResponse {

    Long id;
    String description;
    String status;
    EmployeeResponse employee;
    LocalDateTime executionDate;
    LocalDateTime completedDate;
    Long days;

}
