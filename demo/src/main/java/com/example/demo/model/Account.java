package com.example.demo.model;

import com.example.demo.entities.Account_Entities;
import com.googlecode.objectify.annotation.Id;

public class Account {

    @Id
    private Long id;
    private String nomCompte;
    private Integer amount;
    // If risk == true => High Risk for approval
    private Boolean risk;

    public Account(String nomCompte, Integer amount) {
        this.nomCompte = nomCompte;
        this.amount = amount;
        this.risk = false;
    }

    public Account() {
    }

    public Account(Account_Entities account_entities) {
        this.id = account_entities.getId();
        this.nomCompte = account_entities.getNomCompte();
        this.amount = account_entities.getAmount();
        this.risk = account_entities.getRisk();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomCompte() {
        return nomCompte;
    }
    public void setNomCompte(String nomCompte) {
        this.nomCompte = nomCompte;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public Boolean getRisk() {
        return risk;
    }
    public void setRisk(Boolean risk) {
        this.risk = risk;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", nomCompte='" + nomCompte + '\'' +
                ", amount=" + amount +
                '}';
    }
}
