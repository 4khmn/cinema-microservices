package org.example.booking.service;

import lombok.RequiredArgsConstructor;
import org.example.booking.client.InventoryClient;
import org.example.booking.dto.BookingCreate;
import org.example.booking.dto.BookingResponse;
import org.example.booking.dto.SeatDto;
import org.example.booking.dto.SeatStatusEvent;
import org.example.booking.entity.Booking;
import org.example.booking.enums.SeatEventType;
import org.example.booking.exception.BookingException;
import org.example.booking.mapper.BookingMapper;
import org.example.booking.repository.BookingRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final InventoryClient inventoryClient;
    private final BookingMapper mapper;
    private final BookingRepository bookingRepository;
    private final KafkaTemplate<String, SeatStatusEvent> kafkaTemplate;

    @Transactional
    public BookingResponse createBooking(BookingCreate request) {

        SeatDto seat = inventoryClient.getSeatById(request.seatId());
        if (seat.isReserved()) {
            throw new BookingException("Seat is reserved");
        }

        Booking booking = mapper.toEntity(request);
        bookingRepository.save(booking);

        SeatStatusEvent event = new SeatStatusEvent(
                UUID.randomUUID().toString(),
                seat.id(),
                booking.getId(),
                SeatEventType.RESERVED,
                LocalDateTime.now()
        );

        kafkaTemplate.send("seat-events", event.seatId().toString(), event);

        return mapper.toDto(booking);

    }
}
