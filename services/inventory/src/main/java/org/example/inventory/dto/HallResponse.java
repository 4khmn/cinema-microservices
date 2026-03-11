package org.example.inventory.dto;

public record HallResponse(Long id,
                           String name,
                           Integer totalRows,
                           Integer seatsPerRow) {
}
