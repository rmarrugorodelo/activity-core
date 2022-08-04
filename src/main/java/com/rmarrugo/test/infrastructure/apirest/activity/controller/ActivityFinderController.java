package com.rmarrugo.test.infrastructure.apirest.activity.controller;

import com.rmarrugo.test.domain.activity.Activity;
import com.rmarrugo.test.domain.activity.port.ActivityFinder;
import com.rmarrugo.test.domain.common.PageAsk;
import com.rmarrugo.test.infrastructure.apirest.activity.dto.ActivityResponse;
import com.rmarrugo.test.infrastructure.apirest.activity.mapper.ActivityApiRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Page<ActivityResponse> find(@RequestParam(defaultValue = "0") Integer page,
                                       @RequestParam(defaultValue = "15") Integer size) {
        return ((Page<Activity>) activityFinder.find(getPageAsk(page, size)))
                .map(mapper::toDto);
    }

    private PageAsk getPageAsk(Integer page, Integer size) {
        return PageAsk
                .builder()
                .page(page)
                .size(size)
                .build();
    }


}
