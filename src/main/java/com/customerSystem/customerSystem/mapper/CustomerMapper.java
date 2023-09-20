package com.customersystem.customersystem.mapper;

import com.customersystem.customersystem.model.Customer;
import com.customersystem.customersystem.modeldto.CustomerDto;
import com.customersystem.customersystem.modeldto.UpdateCustomerDto;
import com.customersystem.customersystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerMapper {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDto toCustomerDto(Customer customer) {
        String name = customer.getName();
        String NIK = customer.getNIK();
        String email = customer.getEmail();
        String phone = customer.getPhone();
        String address = customer.getAddress();
        LocalDate DOB = customer.getDOB();

        return new CustomerDto(name, NIK, email, phone, address, DOB);
    }

    public Customer toCustomer(CustomerDto customerDto) {
        return new Customer(customerDto.getName(), customerDto.getNIK(), customerDto.getEmail(), customerDto.getPhone(), customerDto.getAddress(), customerDto.getDOB());
    }

    public Customer toUpdatedCustomer(UpdateCustomerDto updateCustomerDto) {
        Customer customer = customerRepository.findById(updateCustomerDto.getCin()).orElse(null);
        customer.setName(updateCustomerDto.getName());
        customer.setPhone(updateCustomerDto.getPhone());
        customer.setAddress(updateCustomerDto.getAddress());
        customer.setEmail(updateCustomerDto.getEmail());

        return customer;
    }
}
