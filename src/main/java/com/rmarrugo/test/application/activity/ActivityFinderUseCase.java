package com.rmarrugo.test.application.activity;

import com.rmarrugo.test.domain.activity.Activity;
import com.rmarrugo.test.domain.activity.port.ActivityFinder;
import com.rmarrugo.test.domain.activity.port.ActivityFinderRepository;
import com.rmarrugo.test.domain.exception.ErrorCode;
import com.rmarrugo.test.domain.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActivityFinderUseCase implements ActivityFinder {

    private final ActivityFinderRepository finderRepository;

    @Override
    public Activity findById(Long id) {
        return finderRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException(ErrorCode.ACTIVITY_NOT_FOUND)
                );
    }

    @Override
    public List<Activity> findAll() {
        return finderRepository.findAll();
    }

}
