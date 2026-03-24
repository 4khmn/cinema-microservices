package org.example.booking.mapper;

import org.example.booking.dto.BookingCreate;
import org.example.booking.dto.BookingResponse;
import org.example.booking.entity.Booking;
import org.example.booking.enums.BookingStatus;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", imports = {BookingStatus.class})
public interface BookingMapper {

    BookingResponse toDto(Booking booking);

    @Mapping(target = "status", constant = "PENDING")
    Booking toEntity(BookingCreate dto);
}
