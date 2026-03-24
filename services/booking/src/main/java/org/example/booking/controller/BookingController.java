package org.example.booking.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.booking.dto.BookingCreate;
import org.example.booking.dto.BookingResponse;
import org.example.booking.service.BookingService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;


    @PostMapping("/bookings")
    public BookingResponse createBooking(@RequestBody BookingCreate request){
        log.info("Booking request: {}", request);
        BookingResponse booking = bookingService.createBooking(request);
        log.info("end");
        return booking;
    }


}
