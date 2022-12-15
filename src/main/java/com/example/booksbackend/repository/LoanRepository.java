package com.example.booksbackend.repository;

import com.example.booksbackend.entityModel.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}
