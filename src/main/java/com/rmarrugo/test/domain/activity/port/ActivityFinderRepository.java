package com.rmarrugo.test.domain.activity.port;

import com.rmarrugo.test.domain.activity.Activity;
import com.rmarrugo.test.domain.common.PageAsk;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface ActivityFinderRepository {

    Optional<Activity> findById(Long id);

    boolean existsById(Long id);

    Supplier<Stream<Activity>> find(PageAsk pageAsk);

}
