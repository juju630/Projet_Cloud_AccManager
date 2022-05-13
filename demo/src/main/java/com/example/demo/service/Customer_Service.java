package com.example.demo.service;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.exceptions.InternalErrorException;
import com.example.demo.model.Account;
import com.example.demo.model.Customers;
import com.example.demo.repository.Account_Repository;
import com.example.demo.repository.Customer_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Customer_Service {


    @Autowired
    Customer_Repository customer_repository;

    public Customers getOnes(Integer id) throws InternalErrorException, EntityNotFoundException {
        return customer_repository.getOnes(id);
    }

    public List<Customers> getAll() throws InternalErrorException, EntityNotFoundException  {
        return customer_repository.getAll();
    }
}
