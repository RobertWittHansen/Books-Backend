package com.example.booksbackend.service;


import com.example.booksbackend.apiController.ReservationController;
import com.example.booksbackend.repository.MemberRepository;
import com.example.booksbackend.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }



}
