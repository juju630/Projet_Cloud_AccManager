package com.example.demo.service;

import com.example.demo.entities.Account_Entities;
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

    public Account getOnes(Long id) throws InternalErrorException, EntityNotFoundException {
        return new Account(account_repository.getOnes(id));
    }

    public List<Account> getAll() throws InternalErrorException, EntityNotFoundException  {
        return account_repository.getAll().stream().map(Account::new).collect(Collectors.toList());
    }

    public void create(Account account) {
        account_repository.create(account);
    }

    public void delete(Long id) {
        Account_Entities account_entities = account_repository.getOnes(id);
        if(account_entities == null)
            throw new EntityNotFoundException();
        account_repository.delete(account_entities);
    }

    public String evaluateRisk(Long id) {
        Account_Entities account_entities = account_repository.getOnes(id);
        if(account_entities == null || account_entities.getRisk() == null)
            throw new EntityNotFoundException();
        if( !account_entities.getRisk()) {
            return "low";
        }else{
            return "high";
        }
    }

    public void update(Long id, Account account) {
        Account_Entities account_entities = account_repository.getOnes(id);
        if(account_entities == null)
            throw new EntityNotFoundException();
        account_repository.create(account);
    }
}
