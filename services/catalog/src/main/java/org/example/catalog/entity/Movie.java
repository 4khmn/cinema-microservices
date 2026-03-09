package org.example.catalog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;


    private Integer year;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

    @ManyToOne
    @JoinColumn(name = "director_id")
    private Director director;


    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;
}
