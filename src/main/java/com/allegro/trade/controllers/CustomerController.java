package com.allegro.trade.controllers;

import com.allegro.trade.models.Customer;
import com.allegro.trade.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.listAllCustomers());
        return "customers";
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public String getCustomer(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id));
        return "customer";
    }

    @RequestMapping("/customer/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }

    @RequestMapping("/customer/new")
    public String Customer(Model model) {
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public String newOrUpdateCustomer(Customer customer) {
        Customer savedCustomer = customerService.saveOrUpdateCustomer(customer);
        return "redirect:/customer/" + savedCustomer.getId();
    }
}
