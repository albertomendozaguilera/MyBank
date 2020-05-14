package com.alberto.bank.service;

import com.alberto.bank.dao.PaymentTransactionsDao;
import com.alberto.bank.dto.PaymentTransactionsDTO;
import com.alberto.bank.model.PaymentTransactions;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wutuf
 */
@Service
public class PTransactionsService {
    
    @Autowired
    PaymentTransactionsDao paymentTransactionsDao;
    
    @Autowired
    PTransactiosToPTransactionsDTOConverter pTransactiosToPTransactionsDTOConverter;
    
    @Autowired
    PTransactionsDTOToPTransactionsConverter pTransactionsDTOToPTransactionsConverter;
    
    
    public List<PaymentTransactionsDTO> getAllTransactions() {
        List<PaymentTransactionsDTO> pTransactionsDTOList = new ArrayList();
        List<PaymentTransactions> pTransactions = this.paymentTransactionsDao.findAll();
        pTransactions.forEach((user) -> {
            pTransactionsDTOList.add(pTransactiosToPTransactionsDTOConverter.populate(user));
        });
         return pTransactionsDTOList;
     }
 
     public PaymentTransactionsDTO addTransactions(PaymentTransactionsDTO pTransactionsDTO) {
         return pTransactiosToPTransactionsDTOConverter.populate(paymentTransactionsDao.save(pTransactionsDTOToPTransactionsConverter.populate(pTransactionsDTO)));
     }
}
