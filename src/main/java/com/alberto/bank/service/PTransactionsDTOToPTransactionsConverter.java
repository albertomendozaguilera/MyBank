package com.alberto.bank.service;

import com.alberto.bank.dto.PaymentTransactionsDTO;
import com.alberto.bank.dao.PaymentTransactionsDAO;
import org.springframework.stereotype.Service;

/**
 *
 * @author wutuf
 */
@Service
public class PTransactionsDTOToPTransactionsConverter {
    public PaymentTransactionsDAO populate(PaymentTransactionsDTO pTransactionsDTO){
        PaymentTransactionsDAO pTransactions = new PaymentTransactionsDAO();
        pTransactions.setId(pTransactionsDTO.getId());
        //pTransactions.setIban(pTransactionsDTO.getIban());
        pTransactions.setQuantity(pTransactionsDTO.getQuantity());
        pTransactions.setConcept(pTransactionsDTO.getConcept());
        pTransactions.setDatetime(pTransactionsDTO.getDatetime());
        pTransactions.setDestinyAccount(pTransactionsDTO.getDestinyAccount());
        pTransactions.setOriginAccount(pTransactionsDTO.getOriginAccount());
        pTransactions.setBeneficiary(pTransactionsDTO.getBeneficiary());
        return pTransactions;
    } 
}
