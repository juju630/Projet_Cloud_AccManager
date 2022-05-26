package com.example.demo.entities;

import com.example.demo.model.Account;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Account_Entities {

    @Id
    private Long id;

    private String nomCompte;
    private Integer amount;
    private Boolean risk;

    public Account_Entities(String nomCompte, Integer amount) {
        this.nomCompte = nomCompte;
        this.amount = amount;
    }

    public Account_Entities() {
    }

    public Account_Entities(Account account){
        this.id = account.getId();
        this.nomCompte = account.getNomCompte();
        this.amount = account.getAmount();
        this.risk = account.getRisk();
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
