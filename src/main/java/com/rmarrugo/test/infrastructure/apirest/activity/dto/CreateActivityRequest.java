package com.rmarrugo.test.infrastructure.apirest.activity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rmarrugo.test.domain.activity.Activity;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Jacksonized
@Builder
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateActivityRequest {

    @NotBlank
    String description;

    @NotNull
    Long employeeId;

    @NotNull
    LocalDateTime executionDate;

    public Activity toDomain() {
        return Activity
                .builder()
                .description(description)
                .executionDate(executionDate)
                .build();
    }

}
