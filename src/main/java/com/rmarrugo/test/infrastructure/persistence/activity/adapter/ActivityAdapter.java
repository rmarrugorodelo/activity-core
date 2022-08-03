package com.rmarrugo.test.infrastructure.persistence.activity.adapter;

import com.rmarrugo.test.domain.activity.Activity;
import com.rmarrugo.test.domain.activity.port.ActivityFinderRepository;
import com.rmarrugo.test.domain.activity.port.ActivityWriterRepository;
import com.rmarrugo.test.infrastructure.persistence.activity.entity.ActivityEntity;
import com.rmarrugo.test.infrastructure.persistence.activity.repository.ActivityJpaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ActivityAdapter
        implements ActivityWriterRepository, ActivityFinderRepository {

    private final ActivityJpaRepository jpaRepository;
    private final ModelMapper mapper;

    @Override
    public void save(Activity activity) {
        ActivityEntity entity = mapper.map(activity, ActivityEntity.class);
        jpaRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public Optional<Activity> findById(Long id) {
        return jpaRepository.findById(id)
                .map(activity -> mapper.map(activity, Activity.class));
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }

}
