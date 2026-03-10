package org.example.inventory.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.inventory.entity.Hall;
import org.example.inventory.service.HallService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class HallController {

    private final HallService hallService;

    @GetMapping("/halls/{id}")
    public Hall getById (@PathVariable("id") Long id) {
        log.info("start");
        Hall hall = hallService.getById(id);
        log.info("end");
        return hall;
    }


    @GetMapping("/halls")
    public List<Hall> getAll (){
        log.info("start");
        List<Hall> halls = hallService.getAll();
        log.info("end");
        return halls;
    }

    @PostMapping("/halls")
    public Hall createHall(@RequestBody Hall hall){
        log.info("start");
        Hall savedHall = hallService.save(hall);
        log.info("end");
        return savedHall;
    }
}
