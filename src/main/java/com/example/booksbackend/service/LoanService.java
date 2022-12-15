package com.example.booksbackend.service;


import com.example.booksbackend.DTO.LoanRequest;
import com.example.booksbackend.entityModel.Book;
import com.example.booksbackend.entityModel.Loan;
import com.example.booksbackend.entityModel.Member;
import com.example.booksbackend.repository.BookRepository;
import com.example.booksbackend.repository.LoanRepository;
import com.example.booksbackend.repository.MemberRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;


    public LoanService(LoanRepository loanRepository, MemberRepository memberRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public List<Loan> getLoans(){
        return loanRepository.findAll();
    }

    public Loan getloanById(int id){
        return loanRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact not found"));
    }

    public void addLoan(LocalDate dueDate, LocalDate returnDate, String username, int bookId) {
        Member member = memberRepository.findById(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No member with this id found"));
        Book book = bookRepository.findById(bookId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"No member with this id found"));

        Loan loan = new Loan(dueDate, returnDate, book, member);
        loanRepository.save(loan);
    }

    public void editLoan(LoanRequest loanRequest, int id){
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact with this id doesn't exist"));
    }

    public void deleteLoan(int id){
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Contact with this id doesn't exist"));
        loanRepository.delete(loan);
    }
}
