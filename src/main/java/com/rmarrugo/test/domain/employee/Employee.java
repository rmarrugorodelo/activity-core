package com.rmarrugo.test.domain.employee;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Employee {

    Long id;
    String name;

}
