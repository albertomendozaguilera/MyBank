package com.alberto.bank.controller;

import com.alberto.bank.dto.PaymentTransactionsDTO;

import java.util.List;

import com.alberto.bank.service.PaymentTransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/addtransaction", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity addNewTransaction(@RequestBody PaymentTransactionsDTO transactionDTO) {
        paymentTransactionsService.addTransaction(transactionDTO);
        return ResponseEntity.ok().build();
    }

}
