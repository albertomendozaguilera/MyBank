package com.alberto.bank.repository;

import com.alberto.bank.dao.PaymentWayDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentWayRepository extends JpaRepository<PaymentWayDAO, Integer> {

}
