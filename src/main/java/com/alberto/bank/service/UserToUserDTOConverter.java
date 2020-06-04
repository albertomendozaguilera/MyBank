package com.alberto.bank.service;

import com.alberto.bank.dao.AccountDAO;
import com.alberto.bank.dao.PaymentTransactionsDAO;
import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.dto.PaymentTransactionsDTO;
import com.alberto.bank.dto.UserDTO;
import com.alberto.bank.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wutuf
 */
@Service
public class UserToUserDTOConverter {

    @Autowired AccountToAccountDTOConverter accountToAccountDTOConverter;

    public UserDTO populate(UserDao userDAO){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userDAO.getId());
        userDTO.setName(userDAO.getName());
        userDTO.setEmail(userDAO.getEmail());
        userDTO.setBlacklist(isBlacklisted(userDAO.getBlacklist()));
        userDTO.setAccountsList(convert(userDAO.getAccountDAOS()));
        return userDTO;
    }

    public UserDTO userToUserDTO(UserDao userDAO){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userDAO.getId());
        userDTO.setName(userDAO.getName());
        userDTO.setEmail(userDAO.getEmail());
        userDTO.setBlacklist(isBlacklisted(userDAO.getBlacklist()));
        //userDTO.setAccountsList(convert(userDAO.getAccountDAOS()));
        return userDTO;
    }
    
    private boolean isBlacklisted(String blacklist){
        return !blacklist.equals("0");
    }

    private List<AccountDTO> convert(List<AccountDAO> list) {
        List<AccountDTO> accountDtoList = new ArrayList();
        for (AccountDAO aDao : list) {
            accountDtoList.add(accountToAccountDTOConverter.accountToAccountDTO(aDao));
        }
        return accountDtoList;
    }
}
