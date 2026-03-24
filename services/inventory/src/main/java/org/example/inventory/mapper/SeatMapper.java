package org.example.inventory.mapper;

import org.example.inventory.dto.SeatResponse;
import org.example.inventory.entity.Seat;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SeatMapper {
    SeatResponse toDto(Seat seat);
}
