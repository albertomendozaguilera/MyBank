package com.alberto.bank.service;

import com.alberto.bank.dao.PaymentTransactionsDAO;
import com.alberto.bank.dto.AccountDTO;
import com.alberto.bank.dao.AccountDAO;
import com.alberto.bank.dto.PaymentTransactionsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wutuf
 */
@Service
public class AccountToAccountDTOConverter {
    
    @Autowired
    UserToUserDTOConverter userToUserDTOConverter;

    @Autowired
    PTransactiosToPTransactionsDTOConverter pTransactiosToPTransactionsDTOConverter;
    
    public AccountDTO populate(AccountDAO accountDAO){
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setUserDTO(userToUserDTOConverter.userToUserDTO(accountDAO.getUserDAO()));
        accountDTO.setIban(accountDAO.getIban());
        accountDTO.setName(accountDAO.getName());
        accountDTO.setBalance(accountDAO.getBalance());
        accountDTO.setTransactionsDTOList(convert(accountDAO.getTransactionsDAOS()));
        return accountDTO;
    }

    public AccountDTO accountToAccountDTO(AccountDAO accountDAO){
        AccountDTO accountDTO = new AccountDTO();
        //accountDTO.setUserDTO(userToUserDTOConverter.userToUserDTO(accountDAO.getUserDAO()));
        accountDTO.setIban(accountDAO.getIban());
        accountDTO.setName(accountDAO.getName());
        accountDTO.setBalance(accountDAO.getBalance());
        accountDTO.setTransactionsDTOList(convert(accountDAO.getTransactionsDAOS()));
        return accountDTO;
    }

    private List<PaymentTransactionsDTO> convert(List<PaymentTransactionsDAO> list) {
        List<PaymentTransactionsDTO> transactionstDtoList = new ArrayList();
        for (PaymentTransactionsDAO pDao : list) {
            transactionstDtoList.add(pTransactiosToPTransactionsDTOConverter.transactionsToTransactiosDTO(pDao));
        }
        return transactionstDtoList;
    }
}
