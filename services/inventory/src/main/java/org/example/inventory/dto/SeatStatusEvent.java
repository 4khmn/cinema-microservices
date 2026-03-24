package org.example.inventory.dto;

import org.example.inventory.enums.SeatEventType;

import java.time.LocalDateTime;

public record SeatStatusEvent(String eventId,
                              Long seatId,
                              Long bookingId,
                              SeatEventType type,
                              LocalDateTime createdAt) {
}