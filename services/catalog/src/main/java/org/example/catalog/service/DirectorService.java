package org.example.catalog.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.catalog.entity.Director;
import org.example.catalog.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final DirectorRepository directorRepository;

    public Director getById(Long id) {
        return directorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Director with id " + id + " not found")
        );
    }

    public List<Director> getAll() {
        return directorRepository.findAll();
    }

    public Director save(Director director){
        return directorRepository.save(director);
    }
}
