package com.electra.model;

import com.electra.domain.Address;
import lombok.Data;

@Data
public class CustomerModel {

    private long id;
    private String name;
    private String email;
    private Address address;

}
