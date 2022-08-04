package com.rmarrugo.test.infrastructure.apirest.activity.controller;

import com.rmarrugo.test.domain.activity.port.ActivityWriter;
import com.rmarrugo.test.infrastructure.apirest.activity.dto.CreateActivityRequest;
import com.rmarrugo.test.infrastructure.apirest.activity.dto.UpdateActivityRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("v1/activities")
public class ActivityWriterController {

    private final ActivityWriter activityWriter;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@Valid @RequestBody CreateActivityRequest request) {
        activityWriter.create(request.toDomain(), request.getEmployeeId());
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("{id}")
    public void update(@PathVariable Long id, @Valid @RequestBody UpdateActivityRequest request) {
        activityWriter.update(id, request.toDomain(), request.getEmployeeId());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        activityWriter.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("{id}/complete")
    public void complete(@PathVariable Long id) {
        activityWriter.complete(id);
    }

}
