package com.alberto.bank.service;

import com.alberto.bank.dao.LoanDAO;
import com.alberto.bank.dto.LoanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanDTOToLoanConverter {

    @Autowired
    AccountDTOToAccountConverter accountDTOToAccountConverter;

    public LoanDAO populate (LoanDTO loanDTO){
        LoanDAO loanDAO = new LoanDAO();
        loanDAO.setAccountDAO(accountDTOToAccountConverter.populate(loanDTO.getAccountDTO()));
        loanDAO.setLoanNum(loanDTO.getLoanNum());
        loanDAO.setDate(loanDTO.getDate());
        loanDAO.setDescription(loanDTO.getDescription());
        loanDAO.setPaymentWay(loanDTO.getPaymentWay());
        loanDAO.setQuantity(loanDTO.getQuantity());
        loanDAO.setReceiptQuantity(loanDTO.getReceiptQuantity());
        return loanDAO;
    }
}
