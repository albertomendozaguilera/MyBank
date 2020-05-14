package com.alberto.bank.service;

import com.alberto.bank.dto.PaymentTransactionsDTO;
import com.alberto.bank.model.PaymentTransactions;

/**
 *
 * @author wutuf
 */
public class PTransactiosToPTransactionsDTOConverter {
    public PaymentTransactionsDTO populate(PaymentTransactions pTransactions){
        PaymentTransactionsDTO pTransactionsDTO = new PaymentTransactionsDTO();
        pTransactionsDTO.setId(pTransactions.getId());
        pTransactionsDTO.setIban(pTransactions.getIban());
        pTransactionsDTO.setQuantity(pTransactions.getQuantity());
        pTransactionsDTO.setConcept(pTransactions.getConcept());
        pTransactionsDTO.setDatetime(pTransactions.getDatetime());
        pTransactionsDTO.setDestinyAccount(pTransactions.getDestinyAccount());
        pTransactionsDTO.setOriginAccount(pTransactions.getOriginAccount());
        pTransactionsDTO.setBeneficiary(pTransactions.getBeneficiary());
        return pTransactionsDTO;
    } 
}
