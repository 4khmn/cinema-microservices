package org.example.catalog.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.catalog.dto.DirectorCreate;
import org.example.catalog.dto.DirectorResponse;
import org.example.catalog.service.DirectorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class DirectorController {

    private final DirectorService directorService;

    @GetMapping("/directors/{id}")
    public DirectorResponse getById(@PathVariable("id") Long id){
        log.info("start");
        DirectorResponse byId = directorService.getById(id);
        log.info("end");
        return byId;
    }


    @GetMapping("/directors")
    public List<DirectorResponse> getAll(){
        log.info("start");
        List<DirectorResponse> directors = directorService.getAll();
        log.info("end");
        return directors;
    }

    @PostMapping("/directors")
    public DirectorResponse createActor(@RequestBody DirectorCreate director){
        log.info("start");
        DirectorResponse savedDirector = directorService.save(director);
        log.info("end");
        return savedDirector;
    }
}
