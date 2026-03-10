package org.example.inventory.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.inventory.client.MovieClient;
import org.example.inventory.dto.MovieDto;
import org.example.inventory.dto.ScreeningRequest;
import org.example.inventory.dto.ScreeningResponse;
import org.example.inventory.entity.Hall;
import org.example.inventory.entity.Screening;
import org.example.inventory.entity.Seat;
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
    private final MovieClient movieClient;
    private final HallRepository hallRepository;

    public ScreeningResponse getById(Long id) {
        Screening screening = screeningRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Screening with id " + id + " not found"));

        MovieDto movie = movieClient.getMovieById(screening.getMovieId());

        return ScreeningResponse.builder()
                .id(screening.getId())
                .movieTitle(movie.title())
                .hallName(screening.getHall().getName())
                .startTime(screening.getStartTime())
                .price(screening.getPrice())
                .build();
    }

    public List<Screening> getAll() {
        return screeningRepository.findAll();
    }

    @Transactional
    public ScreeningResponse saveScreening(ScreeningRequest request) {
        Hall hall = hallRepository.findById(request.hallId()).orElseThrow(
                () -> new EntityNotFoundException("Hall with id " + request.hallId() + " not found"));
        Screening screening = Screening.builder()
                .hall(hall)
                .price(request.price())
                .startTime(request.startTime())
                .movieId(request.movieId())
                .build();
        return save(screening);
    }

    private ScreeningResponse save(Screening screening) {
        Screening save = screeningRepository.save(screening);
        createSeatsForScreening(screening);

        MovieDto movieDto = movieClient.getMovieById(screening.getMovieId());

        ScreeningResponse response = ScreeningResponse.builder()
                .price(screening.getPrice())
                .id(screening.getId())
                .movieTitle(movieDto.title())
                .hallName(screening.getHall().getName())
                .startTime(screening.getStartTime())
                .build();
        return response;
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
