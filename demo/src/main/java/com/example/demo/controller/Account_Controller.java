package com.example.demo.controller;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.exceptions.InternalErrorException;
import com.example.demo.model.Account;
import com.example.demo.service.Account_Service;
import org.apache.coyote.Response;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Controller classique qui fait appel aux Services

@RestController
@RequestMapping(path = "/account")
public class Account_Controller {

    @Autowired
    Account_Service account_service;

    @GetMapping
    public List<Account> getAll() throws InternalErrorException, EntityNotFoundException {
        try{
            List<Account> accounts;
            accounts =  account_service.getAll();
            return accounts;
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }catch (InternalErrorException e){
            throw new InternalErrorException();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    public Account getOne(@PathVariable Long id) throws InternalErrorException, EntityNotFoundException {
        try{
            return account_service.getOnes(id);
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }catch (InternalErrorException e){
            throw new InternalErrorException();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping
    public void createAccount(@RequestBody Account account){
        try{
            account_service.create(account);
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }catch (InternalErrorException e){
            throw new InternalErrorException();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @PutMapping("/{id}")
    public void updateAccount(@PathVariable Long id,@RequestBody Account account){
        try{
            account_service.update(id,account);
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }catch (InternalErrorException e){
            throw new InternalErrorException();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @GetMapping("/risk/{id}")
    public String evaluateRisk(@PathVariable Long id){
        try{
            return account_service.evaluateRisk(id);
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }catch (InternalErrorException e){
            throw new InternalErrorException();
        }catch (Exception e){
            e.printStackTrace();
        }
        throw new InternalErrorException();
    }

    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id){
        try{
            account_service.delete(id);
        }catch (EntityNotFoundException e) {
            throw new EntityNotFoundException();
        }catch (InternalErrorException e){
            throw new InternalErrorException();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
