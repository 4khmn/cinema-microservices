package org.example.booking.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.booking.enums.BookingStatus;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="bookings")
public class Booking {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "screening_id")
    private Long screeningId;

    @Column(nullable = false, name = "seat_id")
    private Long seatId;

    @Column(nullable = false, name = "user_email")
    private String userEmail;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    @Version
    private Long version;
}

