package com.customerSystem.customerSystem.service;


import com.customerSystem.customerSystem.model.Customer;
import com.customerSystem.customerSystem.repository.CustomerRepository;
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

        return "deleted";
    }


}
