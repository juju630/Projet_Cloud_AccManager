package com.example.demo.model;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Account {

    @Id
    private Integer id;

    private String nomCompte;
    private Integer amount;

    public Account(String nomCompte, Integer amount) {
        this.nomCompte = nomCompte;
        this.amount = amount;
    }
}
