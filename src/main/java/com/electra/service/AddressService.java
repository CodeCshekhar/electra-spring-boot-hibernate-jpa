package com.electra.service;

import com.electra.domain.Address;
import com.electra.repository.AddressRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class AddressService {
    private static final Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    private AddressRepository addressRepository;

    @Cacheable("getAllAddresses")
    public List<Address> getAllAddresses() {
        logger.info("Addresses Retrieved in Services");
        return addressRepository.findAll();
    }

    @Cacheable("getAddressById")
    public Address getAddressById(Long id) {
        logger.info("Address detected by ID in Services");
        return addressRepository.findById(id).orElse(null);
    }

    public Address createAddress(Address address) {
        logger.info("Address Created in Services");
        return addressRepository.save(address);
    }
    public Address updateAddress(Long id, Address updatedAddress) {
        Address address = addressRepository.findById(id).orElse(null);
        if (address != null) {
            address.setStreet(updatedAddress.getStreet());
            address.setCity((updatedAddress.getCity()));
            address.setState(updatedAddress.getState());
            address.setCountry(updatedAddress.getCountry());
            logger.info("Address Updated in Services");
            return addressRepository.save(address);
        }
        return null;
    }

    public void deleteAddress(Long id) {
        logger.info("User deleted");
        addressRepository.deleteById(id);
    }
}
