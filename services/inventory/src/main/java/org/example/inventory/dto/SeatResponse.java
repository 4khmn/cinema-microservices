package org.example.inventory.dto;

public record SeatResponse(Long id,
                           Integer rowNumber,
                           Integer seatNumber,
                           boolean isReserved) {
}
