package com.example.demo.model;

import com.example.demo.entities.Customers_Entities;
import com.googlecode.objectify.annotation.Id;

public class Customers {

    @Id
    private Long id;

    private String nom;
    private String prenom;
    private Account account;

    public Customers(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Customers() {
    }

    public Customers(Customers_Entities customers_entities) {
        this.id = customers_entities.getId();
        this.nom = customers_entities.getNom();
        this.prenom = customers_entities.getPrenom();
        this.account = new Account(customers_entities.getAccount());
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
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
