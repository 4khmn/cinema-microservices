package org.example.booking.dto;

import org.example.booking.enums.SeatEventType;

import java.time.LocalDateTime;

public record SeatStatusEvent(String eventId,
                              Long seatId,
                              Long bookingId,
                              SeatEventType type,
                              LocalDateTime createdAt) {
}
