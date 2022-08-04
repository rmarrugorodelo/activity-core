package com.rmarrugo.test.domain.activity.port;

import com.rmarrugo.test.domain.activity.Activity;

import java.util.List;
import java.util.Optional;

public interface ActivityFinderRepository {

    Optional<Activity> findById(Long id);

    boolean existsById(Long id);

    List<Activity> findAll();

}
