package com.rmarrugo.test.domain.activity.port;

import com.rmarrugo.test.domain.activity.Activity;

public interface ActivityFinder {

    Activity findById(Long id);

}
