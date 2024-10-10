package com.electra.controller;

import com.electra.model.AddressModel;
import com.electra.service.AddressService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/electra")
public class AddressController {

    @Resource(name = "addressService")
    private AddressService addressService;


    @GetMapping("/addresses")
    public List<AddressModel> getAddresses(){
        return addressService.getAllAddresses();
    }

    @GetMapping("/address/{id}")
    public AddressModel getAddress(@PathVariable Long id){
        return addressService.getAddressById(id);
    }


    @PostMapping("/address")
    public AddressModel saveAddress(final @RequestBody AddressModel addressModel){
        return addressService.saveAddress(addressModel);
    }


    @DeleteMapping("/address/{id}")
    public Boolean deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }
}