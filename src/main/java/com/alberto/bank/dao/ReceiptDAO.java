package com.alberto.bank.dao;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "RECEIPTS")
public class ReceiptDAO implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LOAN_NUM", nullable = false)
    private LoanDAO loanDAO;

    @Column(name = "RECEIPT_NUM", nullable = false)
    @Id
    private int receiptNum;

    @Column(name = "RECEIPT_DATE", nullable = false)
    private String receiptDate;

    @Column(name = "RECEIPT_AMOUNT", nullable = false)
    private double receiptAmount;

    @Column(name = "PAYMENT_DATE", nullable = false)
    private String paymentDate;

    @Column(name = "PAYED", nullable = false)
    private String payed;

    public LoanDAO getLoanNum() {
        return loanDAO;
    }

    public void setLoanNum(LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }


    public LoanDAO getLoanDAO() {
        return loanDAO;
    }

    public void setLoanDAO(LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }

    public int getReceiptNum() {
        return receiptNum;
    }

    public void setReceiptNum(int receiptNum) {
        this.receiptNum = receiptNum;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public double getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(double receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPayed() {
        return payed;
    }

    public void setPayed(String payed) {
        this.payed = payed;
    }
}
