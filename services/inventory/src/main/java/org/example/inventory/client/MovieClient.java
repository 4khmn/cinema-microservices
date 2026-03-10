package org.example.inventory.client;

import org.example.inventory.dto.MovieDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "catalog-client", url = "http://localhost:8080/api/movies")
public interface MovieClient {

    @GetMapping("/{id}")
    MovieDto getMovieById(@PathVariable("id") Long id);
}
