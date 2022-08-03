package com.rmarrugo.test.infrastructure.apirest.activity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rmarrugo.test.domain.activity.Activity;
import com.rmarrugo.test.domain.activity.ActivityStatus;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Jacksonized
@Builder
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityRequest {

    @NotBlank
    String description;

    @NotBlank
    String status;

    @NotNull
    Long employeeId;

    public Activity toDomain() {
        return Activity
                .builder()
                .description(description)
                .status(
                        ActivityStatus.fromString(status)
                )
                .build();
    }

}
