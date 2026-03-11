package org.example.inventory.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.inventory.dto.HallCreate;
import org.example.inventory.dto.HallResponse;
import org.example.inventory.entity.Hall;
import org.example.inventory.mapper.HallMapper;
import org.example.inventory.repository.HallRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HallService {

    private final HallRepository hallRepository;
    private final HallMapper mapper;


    public HallResponse getById(Long id) {
        Hall hall = hallRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Hall with id " + id + " not found"));
        return mapper.toDto(hall);
    }

    public List<HallResponse> getAll() {
        List<Hall> halls = hallRepository.findAll();
        return halls.stream().map(mapper::toDto).toList();
    }

    public HallResponse save(HallCreate hall){
        Hall savedHall = hallRepository.save(mapper.toEntity(hall));
        return mapper.toDto(savedHall);
    }
}
