package com.rmarrugo.test.infrastructure.apirest.activity.dto;

import com.rmarrugo.test.domain.activity.ActivityStatus;
import com.rmarrugo.test.domain.employee.Employee;
import com.rmarrugo.test.infrastructure.apirest.employee.dto.EmployeeResponse;
import lombok.Builder;
import lombok.Value;
import lombok.With;

@Builder
@Value
public class ActivityResponse {

    Long id;
    String description;
    String status;
    EmployeeResponse employee;

}
