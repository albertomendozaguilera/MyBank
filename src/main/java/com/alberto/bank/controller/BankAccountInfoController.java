package com.alberto.bank.controller;

import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.service.BankAccountInfoService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wutuf
 */
@RestController
public class BankAccountInfoController {
    
    @Resource
    BankAccountInfoService bankAccountInfoService;
    
    @GetMapping("/bankaccountinfo")
    public AccountDTO getBankAccountInfo(@RequestParam(value="user") String user){
        return bankAccountInfoService.getBankAccount(user);
    }
}
