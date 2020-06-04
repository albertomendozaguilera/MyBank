package com.alberto.bank.dto;

import java.sql.Date;

/**
 *
 * @author wutuf
 */
public class PaymentTransactionsDTO {
    
    private String id;
    private AccountDTO iban;
    private double quantity;
    private String concept;
    private String datetime;
    private String destinyAccount;
    private String originAccount;
    private String beneficiary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AccountDTO getIban() {
        return iban;
    }

    public void setIban(AccountDTO iban) {
        this.iban = iban;
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

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
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
