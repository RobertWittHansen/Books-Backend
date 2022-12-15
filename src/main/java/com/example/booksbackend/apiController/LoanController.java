package com.example.booksbackend.apiController;


import com.example.booksbackend.DTO.LoanRequest;
import com.example.booksbackend.entityModel.Loan;
import com.example.booksbackend.service.LoanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@CrossOrigin
@RestController
@RequestMapping("/api/loans")
public class LoanController {


    LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }



    @GetMapping()
    private List<Loan> getAllLoans(){
        return loanService.getLoans();
    }

    @GetMapping("/{id}")
    public Loan getLoan(@PathVariable int id){
        return loanService.getloanById(id);
    }
    @PostMapping("/")
    public void createLoan(@RequestBody LoanRequest loanRequest){
        loanService.addLoan(loanRequest.getDueDate(), loanRequest.getReturnDate(), loanRequest.getUserName(), loanRequest.getBookId());
    }
    @PutMapping("/{id}")
    public void editLoan(@RequestBody LoanRequest loanRequest, @PathVariable int id){
         loanService.editLoan(loanRequest, id);
    }


    @DeleteMapping("/{id}")
    public void deleteLoan(@PathVariable int id){
        loanService.deleteLoan(id);
    }
}
