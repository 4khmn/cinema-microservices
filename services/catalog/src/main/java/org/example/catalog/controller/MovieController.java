package org.example.catalog.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.catalog.dto.MovieCreate;
import org.example.catalog.dto.MovieResponse;
import org.example.catalog.entity.Movie;
import org.example.catalog.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies/{id}")
    public MovieResponse getById(@PathVariable("id") Long id){
        log.info("start");
        MovieResponse byId = movieService.getById(id);
        log.info("end");
        return byId;
    }

    @GetMapping("/movies")
    public List<MovieResponse> getAll(){
        log.info("start");
        List<MovieResponse> movies = movieService.getAll();
        log.info("end");
        return movies;
    }


    @PostMapping("/movies")
    public MovieResponse createMovie(@RequestBody MovieCreate movie){
        log.info("start");
        MovieResponse savedMovie = movieService.save(movie);
        log.info("end");
        return savedMovie;
    }
}
