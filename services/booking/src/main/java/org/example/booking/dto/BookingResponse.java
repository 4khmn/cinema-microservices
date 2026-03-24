package org.example.booking.dto;

import org.example.booking.enums.BookingStatus;

public record BookingResponse(Long id,
                              Long screeningId,
                              Long seatId,
                              String userEmail,
                              BookingStatus status)
{
}
