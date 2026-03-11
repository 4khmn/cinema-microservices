package org.example.inventory.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.inventory.client.MovieClient;
import org.example.inventory.dto.MovieDto;
import org.example.inventory.dto.ScreeningCreate;
import org.example.inventory.dto.ScreeningResponse;
import org.example.inventory.entity.Hall;
import org.example.inventory.entity.Screening;
import org.example.inventory.entity.Seat;
import org.example.inventory.mapper.ScreeningMapper;
import org.example.inventory.repository.HallRepository;
import org.example.inventory.repository.ScreeningRepository;
import org.example.inventory.repository.SeatRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreeningService {

    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;
    private final ScreeningMapper mapper;

    public ScreeningResponse getById(Long id) {
        Screening screening = screeningRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Screening with id " + id + " not found"));


        return mapper.toDto(screening);
    }

    public List<ScreeningResponse> getAll() {
        List<Screening> screenings = screeningRepository.findAll();
        return screenings.stream().map(mapper::toDto).toList();
    }

    @Transactional
    public ScreeningResponse save(ScreeningCreate dto) {
        Screening savedScreening = screeningRepository.save(mapper.toEntity(dto));
        createSeatsForScreening(savedScreening);
        return mapper.toDto(savedScreening);
    }

    private void createSeatsForScreening(Screening screening) {
        Hall hall = screening.getHall();
        for (int r = 1; r <= hall.getTotalRows(); r++) {
            for (int s = 1; s <= hall.getSeatsPerRow(); s++) {
                Seat seat = Seat.builder()
                        .screening(screening)
                        .rowNumber(r)
                        .seatNumber(s)
                        .isReserved(false)
                        .build();
                seatRepository.save(seat);
            }
        }
    }
}
