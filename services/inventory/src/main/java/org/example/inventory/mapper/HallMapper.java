package org.example.inventory.mapper;

import org.example.inventory.dto.HallCreate;
import org.example.inventory.dto.HallResponse;
import org.example.inventory.entity.Hall;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HallMapper {

    HallResponse toDto(Hall hall);

    Hall toEntity(HallCreate dto);
}
