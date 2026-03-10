package org.example.catalog.mapper;

import org.example.catalog.dto.MovieCreate;
import org.example.catalog.dto.MovieResponse;
import org.example.catalog.entity.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieResponse toDto(Movie movie);

    Movie toEntity(MovieCreate dto);
}
