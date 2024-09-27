package com.albertvtr.contactwebapi.service.address.dtos;

import jakarta.validation.constraints.NotBlank;

public class AddressDTO {

    @NotBlank(message = "You must provide a street")
    private String street;
    @NotBlank(message = "You must provide a number")
    private String number;
    @NotBlank(message = "You must provide a city")
    private String city;
    @NotBlank(message = "You must provide a postcode")
    private String postCode;
    @NotBlank(message = "You must provide a country")
    private String country;

    public AddressDTO() {}

    public AddressDTO(String street, String number, String city, String postCode, String country) {
        setStreet(street);
        setNumber(number);
        setCity(city);
        setPostCode(postCode);
        setCountry(country);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}