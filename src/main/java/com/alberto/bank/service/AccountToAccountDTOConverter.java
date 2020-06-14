package com.alberto.bank.service;

import com.alberto.bank.dao.LoanDAO;
import com.alberto.bank.dao.PaymentTransactionsDAO;
import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.dao.AccountDAO;
import com.alberto.bank.dto.LoanDTO;
import com.alberto.bank.dto.PaymentTransactionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wutuf
 */
@Service
public class AccountToAccountDTOConverter {
    
    @Autowired
    UserToUserDTOConverter userToUserDTOConverter;

    @Autowired
    PTransactiosToPTransactionsDTOConverter pTransactiosToPTransactionsDTOConverter;

    @Autowired
    LoanToLoanDTOConverter loanToLoanDTOConverte;
    
    public AccountDTO populate(AccountDAO accountDAO){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserDTO(userToUserDTOConverter.userToUserDTO(accountDAO.getUserDAO()));
        populateFields(accountDAO, accountDTO);
        return accountDTO;
    }

    private void populateFields(AccountDAO accountDAO, AccountDTO accountDTO) {
        accountDTO.setIban(accountDAO.getIban());
        accountDTO.setName(accountDAO.getName());
        accountDTO.setBalance(accountDAO.getBalance());
        accountDTO.setTransactionsDTOList(convertPaymentTrasnsactionsDAOsToPaymentTransactionsDTO(accountDAO.getTransactionsDAOS()));
        accountDTO.setLoansDTOList(convertLoanDAOsToLoanDTO(accountDAO.getLoanDAOS()));
    }

    public AccountDTO accountToAccountDTO(AccountDAO accountDAO){
        AccountDTO accountDTO = new AccountDTO();
        populateFields(accountDAO, accountDTO);
        return accountDTO;
    }

    private List<PaymentTransactionsDTO> convertPaymentTrasnsactionsDAOsToPaymentTransactionsDTO(List<PaymentTransactionsDAO> list) {
        List<PaymentTransactionsDTO> transactionstDtoList = new ArrayList();
        for (PaymentTransactionsDAO pDao : list) {
            transactionstDtoList.add(pTransactiosToPTransactionsDTOConverter.transactionsToTransactiosDTO(pDao));
        }
        return transactionstDtoList;
    }

    private List<LoanDTO> convertLoanDAOsToLoanDTO(List<LoanDAO> list) {
        List<LoanDTO> loanDtoList = new ArrayList();
        for (LoanDAO loanDao : list) {
            loanDtoList.add(loanToLoanDTOConverte.populate(loanDao));
        }
        return loanDtoList;
    }
}
