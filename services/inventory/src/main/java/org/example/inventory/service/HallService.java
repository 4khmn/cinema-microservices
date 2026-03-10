package org.example.inventory.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.inventory.entity.Hall;
import org.example.inventory.repository.HallRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HallService {

    private final HallRepository hallRepository;


    public Hall getById(Long id) {
        return hallRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Hall with id " + id + " not found"));
    }

    public List<Hall> getAll() {
        return hallRepository.findAll();
    }

    public Hall save(Hall hall){
        return hallRepository.save(hall);
    }
}
