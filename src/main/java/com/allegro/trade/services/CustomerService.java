package com.allegro.trade.services;

import com.allegro.trade.models.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<Customer> listAllCustomers();

    Optional<Customer> getCustomerById(Integer id);

    Customer saveOrUpdateCustomer(Customer customer);

    void deleteCustomer(Integer id);
}
