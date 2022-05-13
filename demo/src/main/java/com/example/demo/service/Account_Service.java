package com.example.demo.service;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.exceptions.InternalErrorException;
import com.example.demo.model.Account;
import com.example.demo.repository.Account_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// C'est ici que l'intelligece se fera

@Service
public class Account_Service {


    @Autowired
    Account_Repository account_repository;

    public Account getOnes(String id) throws InternalErrorException, EntityNotFoundException {
        return new Account(account_repository.getOnes(id));
    }

    public List<Account> getAll() throws InternalErrorException, EntityNotFoundException  {
        return account_repository.getAll().stream().map(Account::new).collect(Collectors.toList());
    }

    public void create(String nom, Integer amount) {
        account_repository.create(nom,amount);
    }
}
