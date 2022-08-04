package com.rmarrugo.test.domain.activity;

import com.rmarrugo.test.domain.employee.Employee;
import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.time.LocalDateTime;

@Builder
@Value
public class Activity {

    @With
    Long id;
    String description;
    @With
    ActivityStatus status;
    @With
    Employee employee;
    LocalDateTime executionDate;
    @With
    LocalDateTime completedDate;

}
