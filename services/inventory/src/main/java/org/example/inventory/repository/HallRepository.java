package org.example.inventory.repository;

import org.example.inventory.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HallRepository extends JpaRepository<Hall,Long> {
}
