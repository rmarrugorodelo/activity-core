package com.rmarrugo.test.infrastructure.persistence.employee.repository;

import com.rmarrugo.test.infrastructure.persistence.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<EmployeeEntity, Long> {
}
