package org.example.catalog.repository;

import org.example.catalog.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor,Long> {
}
