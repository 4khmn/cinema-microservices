package org.example.booking.client;

import org.example.booking.dto.BookingCreate;
import org.example.booking.dto.BookingResponse;
import org.example.booking.dto.SeatDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "inventory-service", url = "http://localhost:8081")
public interface InventoryClient {

    @GetMapping("/api/seats/{id}")
    SeatDto getSeatById(@PathVariable("id") Long id);

}