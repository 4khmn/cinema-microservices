package org.example.inventory.mapper;

import org.example.inventory.client.MovieClient;
import org.example.inventory.dto.HallResponse;
import org.example.inventory.dto.MovieDto;
import org.example.inventory.dto.ScreeningCreate;
import org.example.inventory.dto.ScreeningResponse;
import org.example.inventory.entity.Hall;
import org.example.inventory.entity.Screening;
import org.example.inventory.repository.HallRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class ScreeningMapper {

    @Autowired
    private MovieClient movieClient;

    @Autowired
    private HallRepository hallRepository;

    @Mapping(target = "movieTitle", expression = "java(getMovieTitle(screening.getMovieId()))")
    @Mapping(target = "hallName", source = "hall.name")
    public abstract ScreeningResponse toDto(Screening screening);


    @Mapping(target = "hall", source = "hallId")
    public abstract Screening toEntity(ScreeningCreate dto);

    protected String getMovieTitle(Long movieId) {
        try {
            MovieDto movie = movieClient.getMovieById(movieId);
            return movie.title();
        } catch (Exception e) {
            return "Unknown Movie (Catalog Service Unavailable)";
        }
    }

    protected Hall mapHallIdToHall(Long hallId) {
        return hallId == null ? null : hallRepository.findById(hallId)
                .orElseThrow(() -> new RuntimeException("Hall not found"));
    }
}
