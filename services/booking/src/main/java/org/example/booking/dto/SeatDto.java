package org.example.booking.dto;

public record SeatDto(Long id,
                      Integer rowNumber,
                      Integer seatNumber,
                      boolean isReserved) {
}
