package com.example.booksbackend.apiController;
import com.example.booksbackend.DTO.ReservationRequest;
import com.example.booksbackend.entityModel.Reservation;
import com.example.booksbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@RestController
@RequestMapping("api/reservations")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @GetMapping()
    private List<Reservation> getAllReservations(){
        return reservationService.getReservations();
    }

    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable int id){
        return reservationService.getreservationById(id);
    }

    @PostMapping("/")
    public void makeReservation(@RequestBody ReservationRequest  reservationRequest){
        reservationService.addReservation(reservationRequest.getUserName(), reservationRequest.getBookId());

    }

    @PutMapping("/{id}")
    public void editReservation(@RequestBody ReservationRequest reservationRequest, @PathVariable int id){
        reservationService.editReservation(reservationRequest, id);

    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id){
        reservationService.deleteReservation(id);
    }




















}
