package org.example.catalog.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.catalog.dto.ActorCreate;
import org.example.catalog.dto.ActorResponse;
import org.example.catalog.entity.Actor;
import org.example.catalog.mapper.ActorMapper;
import org.example.catalog.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;
    private final ActorMapper mapper;

    public ActorResponse getById(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Actor with id " + id + " not found")
        );
        return mapper.toDto(actor);
    }

    public List<ActorResponse> getAll() {
        List<Actor> all = actorRepository.findAll();
        return all.stream().map(mapper::toDto).toList();
    }


    public ActorResponse save(ActorCreate dto) {
        Actor savedActor = actorRepository.save(mapper.toEntity(dto));

        return mapper.toDto(savedActor);
    }
}
