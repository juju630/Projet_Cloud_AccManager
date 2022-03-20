package com.example.demo.repository;


import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.exceptions.InternalErrorException;
import com.example.demo.model.Account;
import com.googlecode.objectify.ObjectifyService;

import java.util.List;

// C'est ici que l'on fera les Query SQL pour récupéré les données
public class Account_Repository {




    public Account getOnes(Integer id) throws InternalErrorException, EntityNotFoundException {
        try{
            Account tmp = ObjectifyService.ofy().load().type(Account.class).id(id).now();
            if(tmp == null){
                throw new EntityNotFoundException();
            }
            return tmp;
        }catch (Exception e){
            throw new InternalErrorException();
        }
    }

    public List<Account> getAll() throws InternalErrorException, EntityNotFoundException  {
        try {
            List<Account> accounts = ObjectifyService.ofy().load().type(Account.class).list();
            if (accounts == null) {
                throw new EntityNotFoundException();
            }
            return accounts;
        }catch (Exception e){
            throw new InternalErrorException();
        }
    }
}
