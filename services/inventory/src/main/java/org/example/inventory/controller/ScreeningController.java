package org.example.inventory.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.inventory.dto.ScreeningCreate;
import org.example.inventory.dto.ScreeningResponse;
import org.example.inventory.entity.Screening;
import org.example.inventory.service.ScreeningService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class ScreeningController {

    private final ScreeningService screeningService;

    @GetMapping("/screenings/{id}")
    public ScreeningResponse getById(@PathVariable("id") Long id) {
        log.info("start");
        ScreeningResponse screening = screeningService.getById(id);
        log.info("end");
        return screening;
    }

    @GetMapping("/screenings")
    public List<ScreeningResponse> getAll() {
        log.info("start");
        List<ScreeningResponse> screenings = screeningService.getAll();
        log.info("end");
        return screenings;
    }

    @PostMapping("/screenings")
    public ScreeningResponse createScreening(@RequestBody ScreeningCreate screening) {
        log.info("start");
        ScreeningResponse savedScreening = screeningService.save(screening);
        log.info("end");
        return savedScreening;
    }





}
