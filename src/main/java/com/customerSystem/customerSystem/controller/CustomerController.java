package com.customersystem.customersystem.controller;

import com.customersystem.customersystem.mapper.CustomerMapper;
import com.customersystem.customersystem.model.Customer;
import com.customersystem.customersystem.modeldto.CustomerDto;
import com.customersystem.customersystem.modeldto.StatusMessageDto;
import com.customersystem.customersystem.modeldto.UpdateCustomerDto;
import com.customersystem.customersystem.service.CustomerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    private CustomerService customerService;
    private CustomerMapper customerMapper;

    @Autowired
    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping
    public ResponseEntity<?> allCustomers() {
        StatusMessageDto<List<CustomerDto>> responseMsg = new StatusMessageDto<List<CustomerDto>>();
        try {
            List<Customer> customers = customerService.allCustomers();
            List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();

            for(Customer item:customers) {
                customerDtos.add(customerMapper.toCustomerDto(item));
            }
            responseMsg.setStatus(HttpStatus.OK.value());
            responseMsg.setMessage("Shown successfully");
            responseMsg.setData(customerDtos);

            return ResponseEntity.ok().body(responseMsg);
        } catch(Exception e) {
            responseMsg.setMessage("Failed");

            return ResponseEntity.badRequest().body(responseMsg);
        }
    }

    @PostMapping("findCustomer")
    public ResponseEntity<?> findCustomerById(@RequestParam Long cin) {
        StatusMessageDto<CustomerDto> responseMsg = new StatusMessageDto<CustomerDto>();
        try {
            Customer customer = customerService.findCustomerById(cin);
            CustomerDto customerDto = customerMapper.toCustomerDto(customer);

            responseMsg.setStatus(HttpStatus.OK.value());
            responseMsg.setMessage("Shown successfully");
            responseMsg.setData(customerDto);

            return ResponseEntity.ok().body(responseMsg);
        } catch(Exception e) {
            responseMsg.setMessage("Failed");

            return ResponseEntity.badRequest().body(responseMsg);
        }
    }

    @PostMapping("addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDto customerDto) {
        StatusMessageDto<CustomerDto> responseMsg = new StatusMessageDto<CustomerDto>();

        try{
            Customer customer = customerMapper.toCustomer(customerDto);
            customerService.addCustomer(customer);

            responseMsg.setStatus(HttpStatus.OK.value());
            responseMsg.setMessage("New Customer Added Successfully");
            responseMsg.setData(customerDto);

            return ResponseEntity.ok().body(responseMsg);

        } catch(Exception e) {
            responseMsg.setMessage("Add new customer failed");

            return ResponseEntity.badRequest().body(responseMsg);
        }

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
    public  ResponseEntity<?> updateCustomer(@RequestBody UpdateCustomerDto customerDto) {
        StatusMessageDto<UpdateCustomerDto> responseMsg = new StatusMessageDto<UpdateCustomerDto>();

        try {
            Customer customer = customerMapper.toUpdatedCustomer(customerDto);
            customerService.updateCustomer(customer);

            responseMsg.setStatus(HttpStatus.OK.value());
            responseMsg.setMessage("Customer Updated Successfully");
            responseMsg.setData(customerDto);

            return ResponseEntity.ok().body(responseMsg);
        }catch (Exception e) {
            responseMsg.setMessage("Update customer failed");

            return ResponseEntity.badRequest().body(responseMsg);
        }


    }
/*
    {
        "cin":3
        "name":"Jevent",
        "NIK":"1234567890",
        "email":"jepeng@gmail.com",
        "phone":"1234567",
        "address":"Jln Foresta",
        "DOB":"2002-01-10"
    }
*/
    @PostMapping("deleteCustomer")
    public String deleteCustomer(@RequestParam Long id) {
        return customerService.deleteCustomer(id);
    }


}
