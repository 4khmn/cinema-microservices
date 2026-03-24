package org.example.inventory.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.inventory.dto.SeatResponse;
import org.example.inventory.service.SeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class SeatController {

    private final SeatService seatService;


    @GetMapping("/seats/{id}")
    public SeatResponse getById(@PathVariable("id") Long id) {
        log.info("start");
        SeatResponse seat = seatService.getById(id);
        log.info("end");
        return seat;
    }



}
