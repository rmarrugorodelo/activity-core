package com.rmarrugo.test.domain.activity;

import com.rmarrugo.test.domain.employee.Employee;
import lombok.Builder;
import lombok.Value;
import lombok.With;

@Builder
@Value
public class Activity {

    @With
    Long id;
    String description;
    ActivityStatus status;
    @With
    Employee employee;

}
