package org.example.catalog.dto;

public record MovieResponse(Long id,
                            String title,
                            String description,
                            Integer durationMinutes,
                            Integer year,
                            DirectorResponse director,
                            ActorResponse[] actors) {
}
