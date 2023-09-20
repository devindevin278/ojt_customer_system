package com.customersystem.customersystem.service;


import com.customersystem.customersystem.model.Customer;
import com.customersystem.customersystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> allCustomers() {
        return customerRepository.findAll();
    }

    public Customer updateCustomer(Customer customer) {
        Customer exist = customerRepository.findById(customer.getCin()).orElse(null);

        exist.setName(customer.getName());
        exist.setNIK(customer.getNIK());
        exist.setAddress(customer.getAddress());
        exist.setEmail(customer.getEmail());
        exist.setPhone(customer.getPhone());
        exist.setDOB(customer.getDOB());

        return customerRepository.save(exist);
    }

    public String deleteCustomer(Long id) {
        customerRepository.deleteById(id);

//        call api deposit to delete all accounts by customer


        return "deleted";
    }


}
