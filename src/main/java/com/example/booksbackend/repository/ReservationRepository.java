package com.example.booksbackend.repository;

import com.example.booksbackend.entityModel.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
