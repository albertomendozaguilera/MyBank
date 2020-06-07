/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alberto.bank.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author wutuf
 */
@Entity
@Table(name="ACCOUNTS")
public class AccountDAO implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USERID")
    private UserDao userDAO;
    
    @Column(name = "IBAN")
    @Id
    private String iban;
    
    @Column(name = "NAME", nullable = false, length = 100)
    private String name;
    
    @Column(name = "BALANCE", nullable = false, length = 12)
    private double balance;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "accountDAO")
    private List<PaymentTransactionsDAO> transactionsDAOS;

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public UserDao getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<PaymentTransactionsDAO> getTransactionsDAOS() { return transactionsDAOS; }

    public void setTransactionsDAOS(List<PaymentTransactionsDAO> transactionsDAOS) { this.transactionsDAOS = transactionsDAOS; }
}
