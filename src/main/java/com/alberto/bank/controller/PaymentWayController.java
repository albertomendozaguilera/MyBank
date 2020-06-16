package com.alberto.bank.controller;


import com.alberto.bank.dto.PaymentWayDTO;
import com.alberto.bank.service.PaymentWayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paymentways")
public class PaymentWayController {

    @Autowired
    PaymentWayService paymentWayService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<PaymentWayDTO> getAllPaymentWays() {
        return paymentWayService.getAllPaymentWays();
    }
}
