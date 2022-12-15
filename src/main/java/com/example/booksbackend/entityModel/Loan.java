package com.example.booksbackend.entityModel;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

//---------------Lombok.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//---------------Lombok.
@Entity
public class Loan {
    //---------------Fields / attribute.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_id", nullable = false)
    private int id;

    @Column(length = 255, nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    @CreationTimestamp
    private LocalDate checkoutDate;

    @Column(length = 255,nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dueDate;

    @Column(length = 255,nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate returnDate;

    @ManyToOne
    Book book;

    @ManyToOne
    Member member;

    public Loan(LocalDate dueDate, LocalDate returnDate, Book book, Member member) {
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.book = book;
        this.member = member;
    }
//---------------Fields / attribute.



//---------------Fields / attribute.
//---------------Fields / attribute.



//---------------Database dependencies.
//---------------Database dependencies.

//---------------Reservation class.
//---------------Reservation class.

//---------------Constructor.
//---------------Constructor.


}









