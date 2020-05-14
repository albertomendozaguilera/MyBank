package com.alberto.bank.service;

import com.alberto.bank.dto.PaymentTransactionsDTO;
import com.alberto.bank.model.PaymentTransactions;
import org.springframework.stereotype.Service;

/**
 *
 * @author wutuf
 */
@Service
public class PTransactionsDTOToPTransactionsConverter {
    public PaymentTransactions populate(PaymentTransactionsDTO pTransactionsDTO){
        PaymentTransactions pTransactions = new PaymentTransactions();
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
