package org.example.catalog.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.catalog.entity.Actor;
import org.example.catalog.entity.Director;
import org.example.catalog.repository.DirectorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class DirectorController {

    private final DirectorRepository directorRepository;

    @GetMapping("/directors/{id}")
    public Director getById(@RequestParam("id") Long id){
        log.info("start");
        Director byId = directorRepository.getById(id);
        log.info("end");
        return byId;
    }


    @GetMapping("/directors")
    public List<Director> getAll(){
        log.info("start");
        List<Director> directors = directorRepository.findAll();
        log.info("end");
        return directors;
    }

    @PostMapping("/directors")
    public Director createActor(@RequestBody Director director){
        log.info("start");
        Director savedDirector = directorRepository.save(director);
        log.info("end");
        return savedDirector;
    }
}
