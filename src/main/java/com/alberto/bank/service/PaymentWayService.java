package com.alberto.bank.service;

import com.alberto.bank.dao.PaymentWayDAO;
import com.alberto.bank.dto.PaymentWayDTO;
import com.alberto.bank.repository.PaymentWayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentWayService {
    @Autowired
    PaymentWayRepository paymentWayRepository;

    @Autowired
    PaymentWayToPaymentWayDTOConverter paymentWayToPaymentWayDTOConverter;

    public List<PaymentWayDTO> getAllPaymentWays() {
        List<PaymentWayDTO> paymentWayDTOList = new ArrayList();
        List<PaymentWayDAO> paymentWayDaos = this.paymentWayRepository.findAll();
        paymentWayDaos.forEach((paymentWay) -> {
            paymentWayDTOList.add(paymentWayToPaymentWayDTOConverter.populate(paymentWay));
        });
        return paymentWayDTOList;
    }
}
