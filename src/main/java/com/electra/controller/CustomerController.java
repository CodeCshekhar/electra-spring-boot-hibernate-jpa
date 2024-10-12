package com.electra.controller;

import com.electra.model.CustomerModel;
import com.electra.service.CustomerService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/electra")
public class CustomerController {

    @Resource(name = "customerService")
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerModel> getCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customer/{id}")
    public CustomerModel getCustomer(@PathVariable Long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customer")
    public CustomerModel saveCustomer(final @RequestBody CustomerModel customerModel){
        return customerService.saveCustomer(customerModel);
    }

    @DeleteMapping("/customer/{id}")
    public Boolean deleteCustomer(@PathVariable Long id){
        return customerService.deleteCustomer(id);
    }
}