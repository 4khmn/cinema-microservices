package org.example.inventory.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="seats")
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "screening_id", nullable = false)
    private Screening screening;


    private Integer rowNumber;
    private Integer seatNumber;


    @Column(nullable = false)
    private boolean isReserved = false;

    @Version
    private Long version;


}
