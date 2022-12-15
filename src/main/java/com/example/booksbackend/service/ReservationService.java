package com.example.booksbackend.service;


import com.example.booksbackend.DTO.ReservationRequest;
import com.example.booksbackend.apiController.ReservationController;
import com.example.booksbackend.entityModel.Book;
import com.example.booksbackend.entityModel.Reservation;
import com.example.booksbackend.entityModel.Member;
import com.example.booksbackend.entityModel.Reservation;
import com.example.booksbackend.repository.BookRepository;
import com.example.booksbackend.repository.ReservationRepository;
import com.example.booksbackend.repository.MemberRepository;
import com.example.booksbackend.repository.ReservationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    ReservationRepository reservationRepository;
    MemberRepository memberRepository;

    BookRepository bookRepository;

    private ReservationService(ReservationRepository reservationRepository, MemberRepository memberRepository, BookRepository bookRepository){
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public List<Reservation> getReservations(){
        return reservationRepository.findAll();
    }

    public Reservation getreservationById(int id){
        return reservationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact not found"));
    }

    public void addReservation(String username, int bookId) {
        Member member = memberRepository.findById(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No member with this id found"));
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No member with this id found"));

        Reservation reservation = new Reservation(member, book);
        reservationRepository.save(reservation);
    }

    public void editReservation(ReservationRequest reservationRequest, int id){
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact with this id doesn't exist"));
    }

    public void deleteReservation(int id){
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact with this id doesn't exist"));
        reservationRepository.delete(reservation);
    }









}
