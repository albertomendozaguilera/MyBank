package com.alberto.bank.controller;

import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.service.AccountService;
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
public class AccountController {
    
    @Autowired
    AccountService accountService;
    
    @RequestMapping(value = "/all", method = RequestMethod.GET)
     public List<AccountDTO> getAllUsers() {
         return accountService.getAllAccounts();
     }
 
     @RequestMapping(value = "/addaccount", method = RequestMethod.POST,
             consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
     @ResponseBody()
     public AccountDTO addNewUser(@RequestBody AccountDTO accountDTO) {
         return this.accountService.addAccount(accountDTO);
     }
}
