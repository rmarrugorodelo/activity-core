package com.rmarrugo.test.domain.activity.port;

import com.rmarrugo.test.domain.activity.Activity;
import com.rmarrugo.test.domain.common.PageAsk;

import java.util.function.Supplier;
import java.util.stream.Stream;

public interface ActivityFinder {

    Activity findById(Long id);

    Supplier<Stream<Activity>> find(PageAsk pageAsk);

}
