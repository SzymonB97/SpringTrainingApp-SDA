package com.allegro.trade.services.impl;

import com.allegro.trade.models.Customer;
import com.allegro.trade.repository.CustomerRepository;
import com.allegro.trade.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

//    private Map<Integer, Customer> customers;


    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
//        customers = new HashMap<>();
//        loadCustomers();
        this.customerRepository = customerRepository;
    }

//    private void loadCustomers() {
//        for (int i = 1; i < 6; i++) {
//            Customer c = new Customer();
//            c.setId(i);
//            c.setFirstName("Adam" + i);
//            c.setLastName("Nowak" + i);
//            c.setPhoneNumber("48 555 999 00" + i);
//            c.setEmail("AdamNowak@" + i + ".com");
//            c.setAddressLineOne("Street " + i);
//            c.setAddressLineTwo("Flat " + i);
//            c.setCity("Krakow");
//            c.setZipCode("00-999");
//            c.setState("Main");
//            customers.put(i, c);
//        }
//    }

    @Override
    public List<Customer> listAllCustomers() {
//        return new ArrayList<>(customers.values());
        List<Customer> result = new LinkedList<>();
        customerRepository.findAll().forEach(result::add);
        return result;
    }

    @Override
    public Optional<Customer> getCustomerById(Integer id) {
//        return customers.get(id);
        return customerRepository.findById(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if (customer != null) {
//            if (customer.getId() == null) {
//                customer.setId(getNextKey());
//            }
//            customers.put(customer.getId(), customer);

            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("Can't be null");
        }
    }

    @Override
    public void deleteCustomer(Integer id) {
//        customers.remove(id);
        customerRepository.deleteById(id);
    }

//    private Integer getNextKey() {
//        if (customers.keySet().isEmpty()) {
//            return 1;
//        }
//
//        return Collections.max(customers.keySet()) + 1;
//    }
}
