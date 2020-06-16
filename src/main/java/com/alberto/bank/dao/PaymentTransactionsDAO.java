package com.alberto.bank.dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author wutuf
 */

@Entity
@Table(name="PAYMENT_TRANSACTIONS")    
public class PaymentTransactionsDAO implements Serializable{
        
    @Column(name = "ID")
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne (fetch = FetchType.LAZY)//TODO
    @JoinColumn(name = "ACCOUNT_IBAN", nullable = false)
    private AccountDAO accountDAO;
    
    @Column(name = "QUANTITY", nullable = false, length = 9)
    private double quantity;
    
    @Column(name = "CONCEPT", nullable = false, length = 250)
    private String concept;
    
    @Column(name = "DATETIME", nullable = false)
    private Date datetime;
    
    @Column(name = "DESTINY_ACCOUNT", nullable = false, length = 24)
    private String destinyAccount;
    
    @Column(name = "ORIGIN_ACCOUNT", nullable = false, length = 24)
    private String originAccount;
    
    @Column(name = "BENEFICIARY", nullable = false, length = 100)
    private String beneficiary;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AccountDAO getAccountDao() {
        return accountDAO;
    }

    public void setAccountDao(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getDestinyAccount() {
        return destinyAccount;
    }

    public void setDestinyAccount(String destinyAccount) {
        this.destinyAccount = destinyAccount;
    }

    public String getOriginAccount() {
        return originAccount;
    }

    public void setOriginAccount(String originAccount) {
        this.originAccount = originAccount;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }
    
    
    
}
