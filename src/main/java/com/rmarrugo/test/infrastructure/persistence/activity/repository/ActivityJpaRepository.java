package com.rmarrugo.test.infrastructure.persistence.activity.repository;

import com.rmarrugo.test.infrastructure.persistence.activity.entity.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityJpaRepository extends JpaRepository<ActivityEntity, Long> {
}
