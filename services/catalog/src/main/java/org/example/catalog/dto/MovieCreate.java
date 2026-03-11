package org.example.catalog.dto;

import java.util.List;

public record MovieCreate(String title,
                          String description,
                          Integer durationMinutes,
                          Integer year,
                          Long directorId,
                          List<Long> actorIds) {
}
