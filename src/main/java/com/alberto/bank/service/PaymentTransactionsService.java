package com.alberto.bank.service;

import com.alberto.bank.dao.AccountDAO;
import com.alberto.bank.dao.PaymentTransactionsDAO;
import com.alberto.bank.dto.PaymentTransactionsDTO;
import com.alberto.bank.repository.PaymentTransactionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wutuf
 */
@Service
public class PaymentTransactionsService {
    @Autowired
    PaymentTransactionsRepository transactionsRepository;

    @Autowired
    PTransactiosToPTransactionsDTOConverter pTransactiosToPTransactionsDTOConverter;

    @Autowired
    PTransactionsDTOToPTransactionsConverter pTransactionsDTOToPTransactionsConverter;

    /*public List<PaymentTransactionsDTO> getAllAccounts() {
        List<PaymentTransactionsDTO> transactionsDTOList = new ArrayList();
        List<PaymentTransactionsDAO> transactionsDAOS = this.transactionsRepository.findAll();
        transactionsDAOS.forEach((transaction) -> {
            transactionsDTOList.add(pTransactiosToPTransactionsDTOConverter.populate(transaction));
        });
        return transactionsDTOList;
    }*/

    public List<PaymentTransactionsDTO> getTransactionsByIBAN(String iban){
        List<PaymentTransactionsDAO> transactionsDAOS;
        List<PaymentTransactionsDTO> transactionsList = new ArrayList();

        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        PaymentTransactionsDAO transactionDAO = new PaymentTransactionsDAO();
        AccountDAO accountDAO = new AccountDAO();
        accountDAO.setIban(iban);
        transactionDAO.setAccountDao(accountDAO);

        transactionsDAOS =  this.transactionsRepository.findByAccountDAO(accountDAO);

        transactionsDAOS.forEach((transactionItem) -> {
            transactionsList.add(pTransactiosToPTransactionsDTOConverter.populate(transactionItem));
        });

        return transactionsList;
    }


}
