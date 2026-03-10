package org.example.catalog.mapper;

import org.example.catalog.dto.ActorCreate;
import org.example.catalog.dto.ActorResponse;
import org.example.catalog.entity.Actor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActorMapper {

    ActorResponse toDto(Actor actor);

    Actor toEntity(ActorCreate dto);
}
