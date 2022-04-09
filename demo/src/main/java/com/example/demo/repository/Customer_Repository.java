package com.example.demo.repository;

import com.example.demo.exceptions.EntityNotFoundException;
import com.example.demo.exceptions.InternalErrorException;
import com.example.demo.model.Account;
import com.example.demo.model.Customers;
import com.googlecode.objectify.ObjectifyService;

import java.util.List;

public class Customer_Repository {

    public Customers getOnes(Integer id) throws InternalErrorException, EntityNotFoundException {
        try{
            Customers tmp = ObjectifyService.ofy().load().type(Customers.class).id(id).now();
            if(tmp == null){
                throw new EntityNotFoundException();
            }
            return tmp;
        }catch (Exception e){
            throw new InternalErrorException();
        }
    }

    public List<Customers> getAll() throws InternalErrorException, EntityNotFoundException  {
        try {
            List<Customers> customers = ObjectifyService.ofy().load().type(Customers.class).list();
            if (customers == null) {
                throw new EntityNotFoundException();
            }
            return customers;
        }catch (Exception e){
            throw new InternalErrorException();
        }
    }
}
