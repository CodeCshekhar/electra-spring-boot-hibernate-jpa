package com.electra.controller;

import com.electra.domain.Address;
import com.electra.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Electra/addresses")
public class AddressController {
    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> retrieveAddresses() {
        logger.info("Retrieving all addresses");
        return ResponseEntity.ok(addressService.retrieveAddresses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getAddressById(@PathVariable long id) {
        logger.info("Retrieving address by ID: {}", id);
        Address address = addressService.search(id).orElse(null);
        if (address != null) {
            return ResponseEntity.ok(address);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address) {
        logger.info("Creating address");
        return ResponseEntity.ok(addressService.storeAddress(address));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable long id, @RequestBody Address address) {
        logger.info("Updating address with ID: {}", id);
        return ResponseEntity.ok(addressService.updateAddress(address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable long id) {
        logger.info("Deleting address with ID: {}", id);
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
