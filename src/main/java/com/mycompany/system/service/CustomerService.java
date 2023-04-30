/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.system.service;

import com.mycompany.system.model.business.Customer;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author ro
 */
public interface CustomerService {

    List<Customer> getAll();

    void save(Customer customer);

    void update(Customer customer);

    void delete(int customerId);

}
