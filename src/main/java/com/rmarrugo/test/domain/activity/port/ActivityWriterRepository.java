package com.rmarrugo.test.domain.activity.port;

import com.rmarrugo.test.domain.activity.Activity;

public interface ActivityWriterRepository {

    void save(Activity activity);

    void delete(Long id);

}
