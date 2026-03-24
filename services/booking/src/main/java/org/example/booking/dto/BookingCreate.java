package org.example.booking.dto;

public record  BookingCreate(Long screeningId,
                            Long seatId,
                            String userEmail) {
}
