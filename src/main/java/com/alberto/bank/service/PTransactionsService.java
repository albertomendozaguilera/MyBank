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
    PaymentTransactionsDao pTransactionsDao;
    
    @Autowired
    PTransactiosToPTransactionsDTOConverter pTransactionsToDTO;
    
    @Autowired
    PTransactionsDTOToPTransactionsConverter DTOTopTransactions;
    
    
    public List<PaymentTransactionsDTO> getAllTransactions() {
        List<PaymentTransactionsDTO> pTransactionsDTOList = new ArrayList();
        List<PaymentTransactions> pTransactions = this.pTransactionsDao.findAll();
        pTransactions.forEach((user) -> {
            pTransactionsDTOList.add(pTransactionsToDTO.populate(user));
        });
         return pTransactionsDTOList;
     }
 
     public PaymentTransactionsDTO addTransactions(PaymentTransactionsDTO pTransactionsDTO) {
         return pTransactionsToDTO.populate(pTransactionsDao.save(DTOTopTransactions.populate(pTransactionsDTO)));
     }
}
