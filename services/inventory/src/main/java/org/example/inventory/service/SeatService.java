package org.example.inventory.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.inventory.dto.SeatResponse;
import org.example.inventory.entity.Seat;
import org.example.inventory.mapper.SeatMapper;
import org.example.inventory.repository.SeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;
    private final SeatMapper mapper;

    public List<SeatResponse> findAll() {
        List<Seat> seats = seatRepository.findAll();
        return seats.stream().map(mapper::toDto).toList();
    }

    public SeatResponse getById(Long id) {
        Seat seat = seatRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Seat with id " + id + " not found")
        );
        return mapper.toDto(seat);
    }

    @Transactional
    public void updateSeatReservation(Long id, boolean reserved) {
        Seat seat = seatRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Seat with id " + id + " not found")
        );
        seat.setReserved(reserved);
    }
}
