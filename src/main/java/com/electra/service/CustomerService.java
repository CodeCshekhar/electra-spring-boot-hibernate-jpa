package com.electra.service;

import com.electra.domain.Customer;
import com.electra.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepo;

    public List<Customer> retrieveCustomers() {
        logger.info("Inside CustomerService.retrieveCustomers()");
        return customerRepo.findAll();
    }

    public Customer storeCustomer(Customer customer) {
        logger.info("Inside CustomerService.storeCustomer()");
        return customerRepo.save(customer);
    }

    public void deleteCustomer(long id) {
        logger.info("Inside CustomerService.deleteCustomer()");
        customerRepo.deleteById(id);
    }

    public Optional<Customer> search(long customerId) {
        logger.info("Inside CustomerService.search()");
        return customerRepo.findById(customerId);
    }

    public Customer updateCustomer(Customer customer) {
        logger.info("Inside CustomerService.updateCustomer()");
        return customerRepo.save(customer);
    }
}
