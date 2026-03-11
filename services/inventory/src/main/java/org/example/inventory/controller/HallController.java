package org.example.inventory.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.inventory.dto.HallCreate;
import org.example.inventory.dto.HallResponse;
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
    public HallResponse getById (@PathVariable("id") Long id) {
        log.info("start");
        HallResponse hall = hallService.getById(id);
        log.info("end");
        return hall;
    }


    @GetMapping("/halls")
    public List<HallResponse> getAll (){
        log.info("start");
        List<HallResponse> halls = hallService.getAll();
        log.info("end");
        return halls;
    }

    @PostMapping("/halls")
    public HallResponse createHall(@RequestBody HallCreate hall){
        log.info("start");
        HallResponse savedHall = hallService.save(hall);
        log.info("end");
        return savedHall;
    }
}
