package com.example.demo.service;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.exceptions.InternalErrorException;
import com.example.demo.model.Account;
import com.example.demo.repository.Account_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// C'est ici que l'intelligece se fera

@Service
public class Account_Service {


    @Autowired
    Account_Repository account_repository;

    public Account getOnes(Integer id) throws InternalErrorException, EntityNotFoundException {
        return account_repository.getOnes(id);
    }

    public List<Account> getAll() throws InternalErrorException, EntityNotFoundException  {
        return account_repository.getAll();
    }
}
