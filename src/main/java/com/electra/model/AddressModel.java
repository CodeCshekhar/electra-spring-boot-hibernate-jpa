package com.electra.model;

import lombok.Data;

@Data

public class AddressModel {

    private long id;
    private String street;
    private String city;
    private String state;
    private String country;
    private long postalCode;

}
