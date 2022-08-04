package com.rmarrugo.test.infrastructure.apirest.activity.controller;

import com.rmarrugo.test.domain.activity.port.ActivityFinder;
import com.rmarrugo.test.infrastructure.apirest.activity.dto.ActivityResponse;
import com.rmarrugo.test.infrastructure.apirest.activity.mapper.ActivityApiRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/activities")
public class ActivityFinderController {

    private final ActivityFinder activityFinder;
    private final ActivityApiRestMapper mapper;

    @GetMapping("{id}")
    public ActivityResponse findById(@PathVariable Long id) {
        return mapper.toDto(
                activityFinder.findById(id)
        );
    }

    @GetMapping
    public List<ActivityResponse> findAll() {
        return activityFinder.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }


}
