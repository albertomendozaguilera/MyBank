package com.alberto.bank.service;

import com.alberto.bank.dto.PaymentTransactionsDTO;
import com.alberto.bank.dao.PaymentTransactionsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author wutuf
 */
@Service
public class PTransactionsDTOToPTransactionsConverter {




    @Autowired
    AccountDTOToAccountConverter accountDTOToAccountConverter;

    public PaymentTransactionsDAO populate(PaymentTransactionsDTO pTransactionsDTO){
        PaymentTransactionsDAO pTransactions = new PaymentTransactionsDAO();
        pTransactions.setId(pTransactionsDTO.getId());
        pTransactions.setAccountDao(accountDTOToAccountConverter.populate(pTransactionsDTO.getAccountDTO()));
        pTransactions.setQuantity(pTransactionsDTO.getQuantity());
        pTransactions.setConcept(pTransactionsDTO.getConcept());
        pTransactions.setDatetime(Date.valueOf(pTransactionsDTO.getDatetime()));
        pTransactions.setDestinyAccount(pTransactionsDTO.getDestinyAccount());
        pTransactions.setOriginAccount(pTransactionsDTO.getOriginAccount());
        pTransactions.setBeneficiary(pTransactionsDTO.getBeneficiary());
        return pTransactions;
    } 
}
