package org.example.catalog.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.catalog.entity.Movie;
import org.example.catalog.service.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/movies/{id}")
    public Movie getBuId(@RequestParam("id") Long id){
        log.info("start");
        Movie byId = movieService.getById(id);
        log.info("end");
        return byId;
    }

    @GetMapping("/movies")
    public List<Movie> getAll(){
        log.info("start");
        List<Movie> movies = movieService.getAll();
        log.info("end");
        return movies;
    }
}
