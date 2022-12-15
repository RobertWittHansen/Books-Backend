package com.example.booksbackend.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {

    LocalDate dueDate;
    LocalDate returnDate;
    String userName;
    int bookId;

}
