package com.example.booksbackend.entityModel;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

//---------------Lombok.
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//---------------Lombok.

@Entity //-- Maven -- Et object som vi skal burger i DB-tabel. Fortæller Der skal laves en table af samme navn some object.
public class Book {
    //---------------Fields / attribute.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private int id;
    @Column(name = "isbn_id", nullable = false)
    private int isbn;
    @Column(length = 255)
    private String title;
    @Column(length = 255)
    private String author;
    @Column(length = 255)
    private String publisher;
    @Column(length = 255)
    private int publisherYear;

    public Book(int isbn, String title, String author, String publisher, int publisherYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publisherYear = publisherYear;
    }
//---------------Fields / attribute.


    //---------------Database dependencies.
    //---------------Database dependencies.

    //---------------Reservation class.
    //---------------Reservation class.

    //---------------Constructor.
    //---------------Constructor.



}
