package org.example.catalog.dto;

import java.util.List;

public record MovieResponse(Long id,
                            String title,
                            String description,
                            Integer durationMinutes,
                            Integer year,
                            DirectorResponse director,
                            List<ActorResponse> actors) {
}
