package com.customerSystem.customerSystem.controller;

import com.customerSystem.customerSystem.model.Customer;
import com.customerSystem.customerSystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> allCustomers() {
        return customerService.allCustomers();
    }

    @GetMapping("{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping("addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }
/*
    {
        "name":"Jevent",
            "nik":"1234567890",
            "email":"jepeng@gmail.com",
            "phone":"1234567",
            "address":"Jln Foresta",
            "dob":"2002-01-10"
    }
*/
    @PostMapping("updateCustomer")
    public  Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }
/*
    {
        "name":"Jevent",
            "NIK":"1234567890",
            "email":"jepeng@gmail.com",
            "phone":"1234567",
            "address":"Jln Foresta",
            "DOB":"2002-01-10"
    }
*/
    @GetMapping("deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }


}
