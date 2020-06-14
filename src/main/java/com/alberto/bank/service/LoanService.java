package com.alberto.bank.service;


import com.alberto.bank.dao.AccountDAO;
import com.alberto.bank.dao.LoanDAO;
import com.alberto.bank.dto.LoanDTO;
import com.alberto.bank.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    LoanToLoanDTOConverter loanToLoanDTOConverter;

    @Autowired
    LoanDTOToLoanConverter loanDTOToLoanConverter;

    public List<LoanDTO> getLoanByAccountIban(String iban){
        List<LoanDAO> loanDAOS;
        List<LoanDTO> loansList = new ArrayList();

        AccountDAO accountDAO = new AccountDAO();
        accountDAO.setIban(iban);

        loanDAOS =  this.loanRepository.findByAccountDAO(accountDAO);

        loanDAOS.forEach((loanItem) -> {
            loansList.add(loanToLoanDTOConverter.populate(loanItem));
        });

        return loansList;
    }

    public LoanDTO addLoan(LoanDTO loanDTO) {
        return loanToLoanDTOConverter.populate(loanRepository.save(loanDTOToLoanConverter.populate(loanDTO)));
    }

}
