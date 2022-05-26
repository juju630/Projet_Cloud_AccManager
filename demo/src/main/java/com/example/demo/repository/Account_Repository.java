package com.example.demo.repository;


import com.example.demo.entities.Account_Entities;
import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.exceptions.InternalErrorException;
import com.example.demo.model.Account;
import com.googlecode.objectify.ObjectifyService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

// C'est ici que l'on fera les Query SQL pour récupéré les données
@Service
public class Account_Repository {

    public Account_Entities getOnes(Long id) throws InternalErrorException, EntityNotFoundException {
        try {
            Account_Entities tmp = ObjectifyService.ofy().load().type(Account_Entities.class).id(id).now();
            if (tmp == null) {
                throw new EntityNotFoundException();
            }
            return tmp;
        }catch (EntityNotFoundException e){
            throw new EntityNotFoundException();
        }catch (Exception e){
            e.printStackTrace();
            throw new InternalErrorException();
        }
    }

    public List<Account_Entities> getAll() throws InternalErrorException, EntityNotFoundException  {
        try {
            List<Account_Entities> accounts = ObjectifyService.ofy().load().type(Account_Entities.class).list();
            if (accounts == null) {
                throw new EntityNotFoundException();
            }
            return accounts;
        }catch (Exception e){
            throw new InternalErrorException();
        }
    }

    public void create(Account account) {
        try{
            Account_Entities tmp = new Account_Entities(account);
            ObjectifyService.ofy().save().entity(tmp).now();
        }catch (Exception e){
            e.printStackTrace();
            throw new InternalErrorException();
        }
    }

    public void delete(Account_Entities account_entities) {
        try{
            ObjectifyService.ofy().delete().entity(account_entities).now();
        }catch (Exception e){
            e.printStackTrace();
            throw new InternalErrorException();
        }
    }

}
