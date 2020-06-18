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


    public List<PaymentTransactionsDTO> getTransactionsByIBAN(String iban){
        List<PaymentTransactionsDAO> transactionsDAOS;
        List<PaymentTransactionsDTO> transactionsList = new ArrayList();

        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        PaymentTransactionsDAO transactionDAO = new PaymentTransactionsDAO();
        AccountDAO accountDAO = new AccountDAO();
        accountDAO.setIban(iban);
        transactionDAO.setAccountDao(accountDAO);

        transactionsDAOS =  this.transactionsRepository.findByAccountDAO(accountDAO);

        transactionsDAOS.forEach((transactionItem) -> transactionsList.add(pTransactiosToPTransactionsDTOConverter.populate(transactionItem)));

        return transactionsList;
    }


    public void addTransaction(PaymentTransactionsDTO transactionDTO) {
        //transactionsRepository.save(pTransactionsDTOToPTransactionsConverter.populate(transactionDTO));
        transactionsRepository.insertPaymentTransaction(transactionDTO.getOriginAccount(), transactionDTO.getQuantity(), transactionDTO.getConcept(), transactionDTO.getDestinyAccount(),
                transactionDTO.getBeneficiary());
    }

    public void addTransactionByProcedure(PaymentTransactionsDTO transactionDTO) {
        transactionsRepository.insertPaymentTransaction(transactionDTO.getOriginAccount(), transactionDTO.getQuantity(), transactionDTO.getConcept(), transactionDTO.getDestinyAccount(), transactionDTO.getBeneficiary());
    }

}
