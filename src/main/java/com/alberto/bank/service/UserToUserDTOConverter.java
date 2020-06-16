package com.alberto.bank.service;

import com.alberto.bank.dao.AccountDAO;
import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.dto.UserDTO;
import com.alberto.bank.dao.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(UserToUserDTOConverter.class.getName());

    @Autowired AccountToAccountDTOConverter accountToAccountDTOConverter;

    public UserDTO populate(UserDAO userDAO){
        UserDTO userDTO = getPopulatedUserDTO(userDAO);
        try{
            userDTO.setAccountsList(convertAccountDAOsToAccountDTOs(userDAO.getAccountDAOS()));
            logger.debug("sacando cuentas: "+ userDTO.getAccountsList().get(0).toString());
        }catch (NullPointerException e){
            logger.error("Error retrieving user accounts", e);
        }
        return userDTO;
    }

    public UserDTO userToUserDTO(UserDAO userDAO){
        UserDTO userDTO = getPopulatedUserDTO(userDAO);
        return userDTO;
    }

    private UserDTO getPopulatedUserDTO(UserDAO userDAO) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(userDAO.getId());
        userDTO.setName(userDAO.getName());
        userDTO.setEmail(userDAO.getEmail());
        userDTO.setBlacklist(isBlacklisted(userDAO.getBlacklist()));
        return userDTO;
    }

    private List<AccountDTO> convertAccountDAOsToAccountDTOs(List<AccountDAO> list) {
        List<AccountDTO> accountDtoList = new ArrayList();
        for (AccountDAO aDao : list) {
            accountDtoList.add(accountToAccountDTOConverter.accountToAccountDTO(aDao));
        }
        return accountDtoList;
    }

    private boolean isBlacklisted(String blacklist){
        return !blacklist.equals("0");
    }
}
