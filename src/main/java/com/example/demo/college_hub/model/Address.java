package com.example.demo.college_hub.model;

import java.io.Serializable;

enum AddressType {
    Home, WORK, OTHERS
}

public class Address implements Serializable {
    private static final long serialVersionUID = -7570681885981445452L;
    private Long addressId;
    private String houseNumber;
    private String addressLine1;
    private String addressLine2;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private AddressType addressType;

}
