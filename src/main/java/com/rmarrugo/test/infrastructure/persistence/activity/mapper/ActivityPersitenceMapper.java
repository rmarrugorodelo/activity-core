package com.rmarrugo.test.infrastructure.persistence.activity.mapper;

import com.rmarrugo.test.domain.activity.Activity;
import com.rmarrugo.test.infrastructure.persistence.activity.entity.ActivityEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActivityPersitenceMapper {

    ActivityEntity toEntity(Activity activity);

    Activity toDomain(ActivityEntity activity);

}
