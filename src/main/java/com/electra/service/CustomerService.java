package com.electra.service;

import com.electra.domain.Customer;
import com.electra.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Cacheable("getAllCustomers")
    public List<Customer> getAllCustomers() {
        logger.info("Customers Retrieved in Services");
        return customerRepository.findAll();
    }

    @Cacheable("getCustomerById")
    public Customer getCustomerById(Long id) {
        logger.info("Customer detected by ID in Services");
        return customerRepository.findById(id).orElse(null);
    }

    public Customer createCustomer(Customer customer) {
        logger.info("Customer Created in Services");
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer customer = customerRepository.findById(id).orElse(null);
        if (customer != null) {
            customer.setName(updatedCustomer.getName());
            customer.setEmail(updatedCustomer.getEmail());
            customer.setAddress(updatedCustomer.getAddress());
            logger.info("Customer Updated in Services");
            return customerRepository.save(customer);
        }
        return null;
    }

    public void deleteCustomer(Long id) {
        logger.info("User deleted");
        customerRepository.deleteById(id);
    }
}
