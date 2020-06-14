package com.alberto.bank.service;


import com.alberto.bank.dao.PaymentWayDAO;
import com.alberto.bank.dto.PaymentWayDTO;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class PaymentWayToPaymentWayDTOConverter {
    //Logger logger = LoggerFactory.getLogger(PaymentWayToPaymentWayDTOConverter.class.getName());


    public PaymentWayDTO populate(PaymentWayDAO paymentWayDAO){
        PaymentWayDTO paymentWayDTO = new PaymentWayDTO();

        paymentWayDTO.setCod(paymentWayDAO.getCod());
        paymentWayDTO.setComission(paymentWayDAO.getComission());
        paymentWayDTO.setDescription(paymentWayDAO.getDescription());
        paymentWayDTO.setNumReceipts(paymentWayDAO.getNumReceipts());

        return paymentWayDTO;
    }
}
