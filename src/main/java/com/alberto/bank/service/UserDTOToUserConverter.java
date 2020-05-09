/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alberto.bank.service;

import com.alberto.bank.dto.UserDTO;
import com.alberto.bank.model.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sergio
 */
@Service
public class UserDTOToUserConverter {
    public User populate(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setBlacklist(isBlacklisted(userDTO.isBlacklist()));
        return user;
    } 
    
    private String isBlacklisted(boolean blacklist){
        return blacklist ? "1" : "0";
    }
}
