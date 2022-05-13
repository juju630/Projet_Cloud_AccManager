package com.example.demo.entities;

import com.example.demo.model.Customers;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Customers_Entities {

    @Id
    private Long id;

    private String nom;
    private String prenom;
    private Account_Entities account;

    public Customers_Entities(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Customers_Entities() {
    }

    public Customers_Entities(Customers customers) {
        this.id = customers.getId();
        this.nom = customers.getNom();
        this.prenom = customers.getPrenom();
        this.account = new Account_Entities(customers.getAccount());
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public Account_Entities getAccount() {
        return account;
    }
    public void setAccount(Account_Entities account) {
        this.account = account;
    }
}
