package com.albertvtr.contactwebapi.service.contact.dtos;

import com.albertvtr.contactwebapi.service.address.dtos.AddressDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ContactDTOInput {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    private AddressDTO address;

    private String numVAT;

    public ContactDTOInput() {}

    public ContactDTOInput(String firstName, String lastName, AddressDTO address, String numVAT) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setNumVAT(numVAT);
    }

    public @NotBlank String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank String lastName) {
        this.lastName = lastName;
    }

    public @NotNull AddressDTO getAddress() {
        return address;
    }

    public void setAddress(@NotNull AddressDTO address) {
        this.address = address;
    }

    public String getNumVAT() {
        return numVAT;
    }

    public void setNumVAT(String numVAT) {
        this.numVAT = numVAT;
    }
}
