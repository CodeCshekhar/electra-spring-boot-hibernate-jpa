package com.electra.service;

import com.electra.domain.Address;
import com.electra.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Address save(Address address) {
        return addressRepository.save(address);
    }

    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
