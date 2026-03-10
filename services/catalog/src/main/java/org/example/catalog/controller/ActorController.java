package org.example.catalog.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.catalog.dto.ActorCreate;
import org.example.catalog.entity.Actor;
import org.example.catalog.service.ActorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api")
public class ActorController {

    private final ActorService actorService;


    @GetMapping("/actors/{id}")
    public Actor getById(@RequestParam("id") Long id){
        log.info("start");
        Actor actor = actorService.getById(id);
        log.info("end");
        return actor;
    }

    @GetMapping("/actors")
    public List<Actor> getAll(){
        log.info("start");
        List<Actor> actors = actorService.getAll();
        log.info("end");
        return actors;
    }

    @PostMapping("/actors")
    public Actor create(@RequestBody ActorCreate actor){
        log.info("start");
        Actor createdActor = actorService.save(actor);
        log.info("end");
        return createdActor;
    }

}
