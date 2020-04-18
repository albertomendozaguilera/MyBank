/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alberto.bank.controller;

import com.alberto.bank.dto.BankAccountModel;
import com.alberto.bank.service.BankAccountInfoService;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sergio
 */
@RestController
public class BankAccountInfoController {
    private static final String template = "Hola %s. Esta es tu información bancaria";
    
    @Resource
    BankAccountInfoService bankAccountInfoService;
    
    @GetMapping("/bankaccountinfo")
    public BankAccountModel getBankAccountInfo(@RequestParam(value="user") String user){
        return bankAccountInfoService.getBankAccount(user);
    }
}
