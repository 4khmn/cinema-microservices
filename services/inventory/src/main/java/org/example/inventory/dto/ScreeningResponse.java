package org.example.inventory.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ScreeningResponse(Long id,
                                String movieTitle,
                                String hallName,
                                LocalDateTime startTime,
                                BigDecimal price){
}
