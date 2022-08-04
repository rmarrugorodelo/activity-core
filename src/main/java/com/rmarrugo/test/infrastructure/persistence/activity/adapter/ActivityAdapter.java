package com.rmarrugo.test.infrastructure.persistence.activity.adapter;

import com.rmarrugo.test.domain.activity.Activity;
import com.rmarrugo.test.domain.activity.port.ActivityFinderRepository;
import com.rmarrugo.test.domain.activity.port.ActivityWriterRepository;
import com.rmarrugo.test.domain.common.PageAsk;
import com.rmarrugo.test.infrastructure.persistence.activity.entity.ActivityEntity;
import com.rmarrugo.test.infrastructure.persistence.activity.mapper.ActivityPersitenceMapper;
import com.rmarrugo.test.infrastructure.persistence.activity.repository.ActivityJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class ActivityAdapter
        implements ActivityWriterRepository, ActivityFinderRepository {

    private final ActivityJpaRepository jpaRepository;
    private final ActivityPersitenceMapper mapper;

    @Override
    public void save(Activity activity) {
        ActivityEntity entity = mapper.toEntity(activity);
        jpaRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Optional<Activity> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

    @Override
    public Supplier<Stream<Activity>> find(PageAsk pageAsk) {
        return jpaRepository.findAll(
                PageRequest.of(pageAsk.getPage(), pageAsk.getSize())
        ).map(mapper::toDomain);
    }

}
