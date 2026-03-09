package org.example.catalog.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.catalog.entity.Movie;
import org.example.catalog.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie getById(Long id){
        return movieRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("movie with id " + id + " not found")
        );
    }

    public List<Movie> getAll() {
        return movieRepository.findAll();
    }
}
