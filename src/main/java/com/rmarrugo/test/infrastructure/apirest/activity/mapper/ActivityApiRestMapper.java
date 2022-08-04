package com.rmarrugo.test.infrastructure.apirest.activity.mapper;

import com.rmarrugo.test.domain.activity.Activity;
import com.rmarrugo.test.infrastructure.apirest.activity.dto.ActivityResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Mapper(componentModel = "spring")
public interface ActivityApiRestMapper {

    @Mapping(source = "status.description",target = "status")
    @Mapping(source = "executionDate", target = "days", qualifiedByName = "daysDto")
    ActivityResponse toDto(Activity activity);

    @Named("daysDto")
    default Long locationToLocationDto(LocalDateTime executionDate) {
        long days = ChronoUnit.DAYS.between(executionDate, LocalDateTime.now());
        return Math.max(days, 0L);
    }

}
