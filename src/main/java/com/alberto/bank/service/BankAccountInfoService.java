/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alberto.bank.service;

import com.alberto.bank.dto.BankAccountModel;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sergio
 */
@Service("bankAccountInfoService")
public class BankAccountInfoService {
    
    public BankAccountModel getBankAccount(String user){
        
        //consulta a base de datos 
        // consulto a mysql y vuelcas esa informacion para crear un objeto de tipo BankAccountDAO
        // BankAccountDAOToBankAccountModelConverter
        return new BankAccountModel("000124", user, 3450.74d);        
    }
    
}
