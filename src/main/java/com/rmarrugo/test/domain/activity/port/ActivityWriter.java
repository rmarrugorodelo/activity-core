package com.rmarrugo.test.domain.activity.port;

import com.rmarrugo.test.domain.activity.Activity;

public interface ActivityWriter {

    void create(Activity activity, Long employeeId);

    void update(Long id, Activity activity, Long employeeId);

    void delete(Long id);

    void complete(Long id);

}
