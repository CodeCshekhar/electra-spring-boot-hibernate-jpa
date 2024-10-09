package com.electra.service;

import com.electra.domain.Address;
import com.electra.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private AddressRepository repo;

    public List<Address> retrieveAddresses() {
        logger.info("Inside AddressService.retrieveAddresses()");
        return repo.findAll();
    }

    public Address storeAddress(Address address) {
        logger.info("Inside AddressService.storeAddress()");
        return repo.save(address);
    }

    public String deleteAddress(long id) {
        logger.info("Inside AddressService.deleteAddress()");
        repo.deleteById(id);
        return "Address Deleted";
    }

    public Optional<Address> search(long id) {
        logger.info("Inside AddressService.search()");
        return repo.findById(id);
    }

    public Address updateAddress( Address address) {
        logger.info("Inside AddressService.updateAddress()");;
        return repo.save(address);
    }
}
