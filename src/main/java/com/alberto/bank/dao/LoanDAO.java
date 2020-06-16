package com.alberto.bank.dao;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="LOANS")
public class LoanDAO implements Serializable {

    @Column(name = "LOAN_NUM")
    @Id
    @GeneratedValue
    private int loanNum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "ACCOUNT_IBAN", nullable = false)
    private AccountDAO accountDAO;

    @Column(name = "LOAN_DAT", nullable = false)
    private String date;

    @Column(name = "DESCRIPTION", nullable = false, length = 250)
    private String description;

    @Column(name = "LOAN_QUANTITY", nullable = false)
    private double quantity;

    @Column(name = "RECEIPT_QUANTITY", nullable = false)
    private double receiptQuantity;


    @Column(name = "PAYMENT_WAY", nullable = false)
    private String paymentWay;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loanDAO")
    private List<ReceiptDAO> receiptDAOS;


    public int getLoanNum() {
        return loanNum;
    }

    public void setLoanNum(int loanNum) {
        this.loanNum = loanNum;
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public void setAccountDAO(AccountDAO account_iban) {
        this.accountDAO = account_iban;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getReceiptQuantity() {
        return receiptQuantity;
    }

    public void setReceiptQuantity(double receiptQuantity) {
        this.receiptQuantity = receiptQuantity;
    }

    public String getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(String paymentWay) {
        this.paymentWay = paymentWay;
    }

    public List<ReceiptDAO> getReceiptDAOS() {
        return receiptDAOS;
    }

    public void setReceiptDAOS(List<ReceiptDAO> receiptDAOS) {
        this.receiptDAOS = receiptDAOS;
    }
}
