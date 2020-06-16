package com.alberto.bank.service;


import com.alberto.bank.dao.LoanDAO;
import com.alberto.bank.dao.ReceiptDAO;
import com.alberto.bank.dto.LoanDTO;
import com.alberto.bank.dto.ReceiptDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
    public class LoanToLoanDTOConverter {

    @Autowired
    AccountToAccountDTOConverter accountToAccountDTOConverter;

    @Autowired
    ReceiptToReceiptDTOConverter receiptToReceiptDTOConverter;

    public LoanDTO populate (LoanDAO loanDAO){
        LoanDTO loanDTO = new LoanDTO();

        //loanDTO.setAccountDTO(accountToAccountDTOConverter.accountToAccountDTO(loanDAO.getAccountDAO()));
        populateFields(loanDAO, loanDTO);
        //loanDTO.setReceiptsList(convertReceiptDAOsToReceiptDTOs(loanDAO.getReceiptDAOS()));

        return loanDTO;
    }

    public LoanDTO loanToLoanDTO (LoanDAO loanDAO){
        LoanDTO loanDTO = new LoanDTO();

        populateFields(loanDAO, loanDTO);

        return loanDTO;
    }

    private void populateFields(LoanDAO loanDAO, LoanDTO loanDTO) {
        loanDTO.setLoanNum(loanDAO.getLoanNum());
        loanDTO.setDate(loanDAO.getDate());
        loanDTO.setDescription(loanDAO.getDescription());
        loanDTO.setPaymentWay(loanDAO.getPaymentWay());
        loanDTO.setQuantity(loanDAO.getQuantity());
        loanDTO.setReceiptQuantity(loanDAO.getReceiptQuantity());
    }

    private List<ReceiptDTO> convertReceiptDAOsToReceiptDTOs(List<ReceiptDAO> receiptDAOS){
        List<ReceiptDTO> receiptDTOS = new ArrayList();
        for (ReceiptDAO receiptDAO : receiptDAOS){
            receiptDTOS.add(receiptToReceiptDTOConverter.pupulate(receiptDAO));
        }
        return receiptDTOS;
    }
}
