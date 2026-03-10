package org.example.inventory.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class ScreeningResponse {
    private Long id;
    private String movieTitle;
    private String hallName;
    private LocalDateTime startTime;
    private BigDecimal price;
}
