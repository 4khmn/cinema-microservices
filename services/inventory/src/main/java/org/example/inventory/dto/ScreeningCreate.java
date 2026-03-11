package org.example.inventory.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ScreeningCreate(Long movieId,
                              Long hallId,
                              LocalDateTime startTime,
                              BigDecimal price){
}
