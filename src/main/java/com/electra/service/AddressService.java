package com.electra.service;

import com.electra.model.AddressModel;

import java.util.List;

public interface AddressService {

    AddressModel saveAddress(AddressModel address);
    boolean deleteAddress(final Long addressId);
    List<AddressModel> getAllAddresses();
    AddressModel getAddressById(final Long addressId);

}
