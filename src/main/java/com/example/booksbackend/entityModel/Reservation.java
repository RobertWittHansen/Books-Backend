package com.example.booksbackend.entityModel;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

//---------------Lombok.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//---------------Lombok.

@Entity //-- Maven -- Et object som vi skal burger i DB-tabel. Fortæller Der skal laves en table af samme navn some object.
public class Reservation {
    //---------------Fields / attribute.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @CreationTimestamp
    private LocalDateTime reservationDate;
    //---------------Fields / attribute.

    //---------------Database dependencies.
    @ManyToOne
    Member member;

    @ManyToOne
    Book book;
    //---------------Database dependencies.



//---------------Reservation class.
//---------------Reservation class.

//---------------Constructor.
//---------------Constructor.



}




