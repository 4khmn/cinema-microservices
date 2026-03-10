package org.example.catalog.mapper;

import org.example.catalog.dto.DirectorCreate;
import org.example.catalog.dto.DirectorResponse;
import org.example.catalog.entity.Director;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DirectorMapper {

    DirectorResponse toDto(Director director);

    Director toEntity(DirectorCreate dto);
}
