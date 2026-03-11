package org.example.inventory.dto;

public record HallCreate(String name,
                         Integer totalRows,
                         Integer setasPerRow) {
}
