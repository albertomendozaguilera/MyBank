package com.alberto.bank.service;

import com.alberto.bank.dto.UserDTO;
import com.alberto.bank.model.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author wutuf
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
