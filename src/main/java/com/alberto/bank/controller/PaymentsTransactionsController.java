package com.alberto.bank.controller;

import com.alberto.bank.dto.PaymentTransactionsDTO;
import com.alberto.bank.service.PTransactionsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wutuf
 */
@RestController
@RequestMapping("/transactions")
public class PaymentsTransactionsController {
    
    @Autowired
    PTransactionsService pTransactionsService;
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
     public List<PaymentTransactionsDTO> getAllTransactions() {
         return pTransactionsService.getAllTransactions();
     }
 
     @RequestMapping(value = "/addtransaction", method = RequestMethod.POST,
             consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
     @ResponseBody()
     public PaymentTransactionsDTO addNewTransaction(@RequestBody PaymentTransactionsDTO transactionDTO) {
         return this.pTransactionsService.addTransactions(transactionDTO);
     }
}
