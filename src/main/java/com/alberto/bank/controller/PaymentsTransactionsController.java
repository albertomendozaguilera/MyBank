package com.alberto.bank.controller;

import com.alberto.bank.dto.PaymentTransactionsDTO;

import java.util.List;

import com.alberto.bank.service.PaymentTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author wutuf
 */
@RestController
@RequestMapping("/transactions")
public class PaymentsTransactionsController {
    
    @Autowired
    PaymentTransactionsService paymentTransactionsService;
    
    @RequestMapping(value = "/myaccount", method = RequestMethod.GET)
     public List<PaymentTransactionsDTO> getTransactionsByIBAN(@RequestParam(value = "userId") String iban) {
         return paymentTransactionsService.getTransactionsByIBAN(iban);
     }

}
