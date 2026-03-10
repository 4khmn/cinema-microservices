package org.example.catalog.dto;

public record MovieCreate(String title,
                          String description,
                          Integer durationMinutes,
                          Integer year,
                          Long directorId,
                          Long[] actorIds) {

}
