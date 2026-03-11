package org.example.catalog.mapper;

import org.example.catalog.dto.MovieCreate;
import org.example.catalog.dto.MovieResponse;
import org.example.catalog.entity.Actor;
import org.example.catalog.entity.Director;
import org.example.catalog.entity.Movie;
import org.example.catalog.repository.ActorRepository;
import org.example.catalog.repository.DirectorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {DirectorMapper.class, ActorMapper.class})
public abstract class MovieMapper {


    @Autowired
    protected DirectorRepository directorRepository;
    @Autowired
    protected ActorRepository actorRepository;


    public abstract MovieResponse toDto(Movie movie);

    @Mapping(target = "director", source = "directorId")
    @Mapping(target = "actors", source = "actorIds")
    public abstract Movie toEntity(MovieCreate dto);


    protected Director mapDirectorIdToDirector(Long directorId) {
        if (directorId == null) return null;
        return directorRepository.findById(directorId).orElse(null);
    }

    protected List<Actor> mapActorIdsToActors(List<Long> actorIds) {
        if (actorIds == null || actorIds.isEmpty()) return List.of();
        return actorRepository.findAllById(actorIds);
    }
}
