package com.example.booksbackend.apiController;


import com.example.booksbackend.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/{member_id}/{book_id}/{date}")
    public void makeReservation(@PathVariable String member_id, @PathVariable int book_id, @PathVariable String date ){
        return;
    }


















}
