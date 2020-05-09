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
public class UserToUserDTOConverter {
    
    public UserDTO populate(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setBlacklist(isBlacklisted(user.getBlacklist()));
        return userDTO;
    } 
    
    private boolean isBlacklisted(String blacklist){
        return !blacklist.equals("0");
    }
}
