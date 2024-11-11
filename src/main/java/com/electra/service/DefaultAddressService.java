package com.electra.service;

import com.electra.domain.Address;
import com.electra.model.AddressModel;
import com.electra.repository.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("addressService")
public class DefaultAddressService implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressModel saveAddress(AddressModel address) {
        Address addressModel = populateAddressEntity(address);
        return populateAddressModel(addressRepository.save(addressModel));
    }

    @Override
    public boolean deleteAddress(Long addressId) {
        addressRepository.deleteById(addressId);
        return true;
    }

    @Override
    public List<AddressModel> getAllAddresses() {
        List<AddressModel> addresses = new ArrayList<>();
        List<Address> addressList = addressRepository.findAll();
        addressList.forEach(address -> {
            addresses.add(populateAddressModel(address));
        });
        return addresses;
    }

    @Override
    public AddressModel getAddressById(Long addressId) {
        return populateAddressModel( addressRepository.findById(addressId).orElseThrow(() -> new EntityNotFoundException("Customer not found")));
    }

    private AddressModel populateAddressModel(final Address address){
        AddressModel addressModel = new AddressModel();
        addressModel.setId(address.getId());
        addressModel.setStreet(address.getStreet());
        addressModel.setCity(address.getCity());
        addressModel.setState(address.getState());
        addressModel.setCountry(address.getCountry());
        addressModel.setPostalCode(address.getPostalCode());
        return  addressModel;
    }

    private Address populateAddressEntity(AddressModel addressModel){
        Address address = new Address();
        address.setStreet(addressModel.getStreet());
        address.setCity(addressModel.getCity());
        address.setState(addressModel.getState());
        address.setCountry(addressModel.getCountry());
        address.setPostalCode(addressModel.getPostalCode());
        return  address;
    }
}
