package org.example.catalog.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.catalog.dto.MovieCreate;
import org.example.catalog.dto.MovieResponse;
import org.example.catalog.entity.Movie;
import org.example.catalog.mapper.MovieMapper;
import org.example.catalog.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper mapper;

    public MovieResponse getById(Long id){
        Movie movie = movieRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("movie with id " + id + " not found")
        );
        return mapper.toDto(movie);
    }

    public List<MovieResponse> getAll() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream().map(mapper::toDto).toList();
    }

    public MovieResponse save(MovieCreate movie){
        Movie savedMovie = movieRepository.save(mapper.toEntity(movie));
        return mapper.toDto(savedMovie);
    }
}
