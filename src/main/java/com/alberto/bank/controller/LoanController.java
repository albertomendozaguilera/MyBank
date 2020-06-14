package com.alberto.bank.controller;


import com.alberto.bank.dto.LoanDTO;
import com.alberto.bank.repository.LoanRepository;
import com.alberto.bank.service.LoanService;
import com.alberto.bank.service.LoanToLoanDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    LoanService loanService;

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    LoanToLoanDTOConverter loanToLoanDTOConverter;

    @RequestMapping(value = "/addloan", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    public void addNewLoan(@RequestBody LoanDTO loanDTO) {loanService.addLoan(loanDTO);
    }
}
