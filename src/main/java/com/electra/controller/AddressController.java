package com.electra.controller;

import com.electra.domain.Address;
import com.electra.service.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    private static final Logger logger = LoggerFactory.getLogger(AddressController.class);

    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> retrieveAddresses() {
        logger.info("Retrieving all addresses");
        return ResponseEntity.ok(addressService.retrieveAddresses());
    }

    @PostMapping
    public ResponseEntity<Address> storeAddress(@RequestBody Address address) {
        logger.info("Storing address");
        return ResponseEntity.ok(addressService.storeAddress(address));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable long id) {
        logger.info("Deleting address with id: {}", id);
        return ResponseEntity.ok(addressService.deleteAddress(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Address>> search(@PathVariable long id) {
        logger.info("Searching for address with id: {}", id);
        return ResponseEntity.ok(addressService.search(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable long id, @RequestBody Address address) {
        logger.info("Updating address with id: {}", id);
        return ResponseEntity.ok(addressService.updateAddress(address));
    }
}
