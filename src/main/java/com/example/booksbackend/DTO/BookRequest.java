package com.example.booksbackend.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    int isbn;
    String title;
    String author;
    String publisher;
    int publisherYear;

}
