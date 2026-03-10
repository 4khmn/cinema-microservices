package org.example.catalog.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.catalog.dto.ActorCreate;
import org.example.catalog.dto.ActorResponse;
import org.example.catalog.repository.ActorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    public ActorResponse getById(Long id) {
        return actorRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Actor with id " + id + " not found")
        );
    }

    public List<ActorResponse> getAll(){
        return actorRepository.findAll();
    }


    public ActorResponse save(ActorCreate actor){
        return actorRepository.save(actor);
    }
}
