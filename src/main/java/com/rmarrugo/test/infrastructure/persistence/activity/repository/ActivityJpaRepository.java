package com.rmarrugo.test.infrastructure.persistence.activity.repository;

import com.rmarrugo.test.infrastructure.persistence.activity.entity.ActivityEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ActivityJpaRepository extends PagingAndSortingRepository<ActivityEntity, Long> {
}
