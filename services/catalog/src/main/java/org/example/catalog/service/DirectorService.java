package org.example.catalog.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.catalog.dto.DirectorCreate;
import org.example.catalog.dto.DirectorResponse;
import org.example.catalog.entity.Director;
import org.example.catalog.mapper.DirectorMapper;
import org.example.catalog.repository.DirectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorService {

    private final DirectorRepository directorRepository;
    private final DirectorMapper mapper;

    public DirectorResponse getById(Long id) {
        Director director = directorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Director with id " + id + " not found")
        );
        return mapper.toDto(director);
    }

    public List<DirectorResponse> getAll() {
        List<Director> all = directorRepository.findAll();
        return all.stream().map(mapper::toDto).toList();
    }

    public DirectorResponse save(DirectorCreate director){
        Director savedDirector = directorRepository.save(mapper.toEntity(director));
        return mapper.toDto(savedDirector);
    }
}
