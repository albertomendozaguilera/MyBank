package com.alberto.bank.service;


import com.alberto.bank.dao.ReceiptDAO;
import com.alberto.bank.dto.ReceiptDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptToReceiptDTOConverter {

    @Autowired
    AccountToAccountDTOConverter accountToAccountDTOConverter;

    @Autowired
    LoanToLoanDTOConverter loanToLoanDTOConverter;

    public ReceiptDTO pupulate(ReceiptDAO receiptDAO) {
        ReceiptDTO receiptDTO = new ReceiptDTO();

        receiptDTO.setLoanDTO(loanToLoanDTOConverter.loanToLoanDTO(receiptDAO.getLoanDAO()));
        receiptDTO.setPaymentDate(receiptDAO.getPaymentDate());
        receiptDTO.setReceiptAmount(receiptDAO.getReceiptAmount());
        receiptDTO.setReceiptDate(receiptDAO.getReceiptDate());
        receiptDTO.setReceiptNum(receiptDAO.getReceiptNum());
        receiptDTO.setPayed(receiptDAO.getPayed());

        return receiptDTO;
    }
}
