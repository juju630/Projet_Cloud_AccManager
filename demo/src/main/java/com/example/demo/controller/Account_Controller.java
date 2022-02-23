package com.example.demo.controller;

import com.example.demo.model.Account;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Controller classique qui fait appel aux Services

@RestController
public class Account_Controller {

    @GetMapping
    public List<Account> getAll(){
        return new ArrayList<>();
    }

    @GetMapping("/{id}")
    public Account getOne(){
        return new Account();
    }

    // A voir comment on passe les données.
    @PostMapping
    public void createAccount(){

    }

    @PutMapping("/{id}")
    public void updateAccount(@PathVariable Integer id){

    }
}
