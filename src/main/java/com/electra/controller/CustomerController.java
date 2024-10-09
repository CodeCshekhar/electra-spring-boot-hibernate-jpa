package com.electra.controller;

import com.electra.domain.Customer;
import com.electra.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> retrieveCustomers() {
        logger.info("Retrieving all customers");
        return ResponseEntity.ok(customerService.retrieveCustomers());
    }

    @PostMapping
    public ResponseEntity<Customer> storeCustomer(@RequestBody Customer customer) {
        logger.info("Storing customer");
        return ResponseEntity.ok(customerService.storeCustomer(customer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable long id) {
        logger.info("Deleting customer with id: {}", id);
        return ResponseEntity.ok(customerService.deleteCustomer(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> search(@PathVariable long id) {
        logger.info("Searching for customer with id: {}", id);
        return ResponseEntity.ok(customerService.search(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable long id, @RequestBody Customer customer) {
        logger.info("Updating customer with id: {}", id);
        return ResponseEntity.ok(customerService.updateCustomer(customer));
    }
}
