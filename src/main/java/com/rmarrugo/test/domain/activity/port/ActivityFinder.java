package com.rmarrugo.test.domain.activity.port;

import com.rmarrugo.test.domain.activity.Activity;

import java.util.List;

public interface ActivityFinder {

    Activity findById(Long id);

    List<Activity> findAll();

}
