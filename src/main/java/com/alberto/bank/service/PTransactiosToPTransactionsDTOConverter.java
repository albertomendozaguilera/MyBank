package com.alberto.bank.service;

import com.alberto.bank.dto.PaymentTransactionsDTO;
import com.alberto.bank.dao.PaymentTransactionsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wutuf
 */
@Service
public class PTransactiosToPTransactionsDTOConverter {

    @Autowired
    AccountToAccountDTOConverter accountToAccountDTOConverter;

    public PaymentTransactionsDTO populate(PaymentTransactionsDAO pTransactions){
        PaymentTransactionsDTO pTransactionsDTO = new PaymentTransactionsDTO();
        pTransactionsDTO.setId(pTransactions.getId());
        pTransactionsDTO.setIban(accountToAccountDTOConverter.populate(pTransactions.getAccountDao()));
        populateFields(pTransactions, pTransactionsDTO);
        return pTransactionsDTO;
    }

    public PaymentTransactionsDTO transactionsToTransactiosDTO(PaymentTransactionsDAO pTransactions){
        PaymentTransactionsDTO pTransactionsDTO = new PaymentTransactionsDTO();
        pTransactionsDTO.setId(pTransactions.getId());
        //pTransactionsDTO.setIban(accountToAccountDTOConverter.populate(pTransactions.getAccountDao()));
        populateFields(pTransactions, pTransactionsDTO);
        return pTransactionsDTO;
    }

    private void populateFields(PaymentTransactionsDAO pTransactions, PaymentTransactionsDTO pTransactionsDTO) {
        pTransactionsDTO.setQuantity(pTransactions.getQuantity());
        pTransactionsDTO.setConcept(pTransactions.getConcept());
        pTransactionsDTO.setDatetime(String.valueOf(pTransactions.getDatetime()));
        pTransactionsDTO.setDestinyAccount(pTransactions.getDestinyAccount());
        pTransactionsDTO.setOriginAccount(pTransactions.getOriginAccount());
        pTransactionsDTO.setBeneficiary(pTransactions.getBeneficiary());
    }
}
