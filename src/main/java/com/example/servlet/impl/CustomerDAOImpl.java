package com.example.servlet.impl;

import com.example.servlet.dao.CustomerDAO;
import com.example.servlet.entity.Customer;
import com.example.servlet.util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    EntityManager en;
    EntityTransaction tran;

    public CustomerDAOImpl() {
        en = PersistenceUtil.createEntityManagerFactory().createEntityManager();
        tran = en.getTransaction();
    }

    @Override
    public void createCustomer(Customer customer) {
        try {
            tran.begin();
            en.persist(customer);
            tran.commit();
        } catch (Exception ex) {
            System.out.printf(ex.getMessage());
            tran.rollback();
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try {
            Query query = en.createQuery("select c from Customer c");
            return query.getResultList();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return customers;
    }
}