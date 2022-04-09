package com.example.demo.controller;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.exceptions.InternalErrorException;
import com.example.demo.model.Account;
import com.example.demo.model.Customers;
import com.example.demo.service.Account_Service;
import com.example.demo.service.Customer_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Controller classique qui fait appel aux Services

@RestController
@RequestMapping(path = "/customer")
public class Customer_Controller {


    @Autowired
    Customer_Service customer_service;

    @GetMapping
    public List<Customers> getAll() throws InternalErrorException, EntityNotFoundException {
        try{
            return customer_service.getAll();
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }catch (InternalErrorException e){
            throw new InternalErrorException();
        }
    }

    @GetMapping("/{id}")
    public Customers getOne(@PathVariable Integer id) throws InternalErrorException, EntityNotFoundException {
        try{
            return customer_service.getOnes(id);
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }catch (InternalErrorException e){
            throw new InternalErrorException();
        }
    }

    @PostMapping
    public void createAccount(){


    }

    @PutMapping("/{id}")
    public void updateAccount(@PathVariable Integer id){

    }
}
