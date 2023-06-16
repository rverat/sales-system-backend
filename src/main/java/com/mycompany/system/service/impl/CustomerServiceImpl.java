/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.system.service.impl;

import com.mycompany.system.dao.CustomerDAO;
import com.mycompany.system.mapper.CustomerMapper;
import com.mycompany.system.model.business.Customer;
import com.mycompany.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ro
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> getAll() {
        return customerMapper.customerDTOListToCustomerList(customerDAO.findAll());
    }

    @Override
    public void save(Customer customer) {
        customerDAO.save(customerMapper.customerToCustomerDTO(customer));
    }

    @Override
    public void update(Customer customer) {
        customerDAO.save(customerMapper.customerToCustomerDTO(customer));
    }

    @Override
    public void delete(int customerId) {
        customerDAO.deleteById(customerId);
    }
}

