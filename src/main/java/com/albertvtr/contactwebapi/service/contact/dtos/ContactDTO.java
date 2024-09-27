package com.albertvtr.contactwebapi.service.contact.dtos;

import com.albertvtr.contactwebapi.model.entities.ContactType;
import com.albertvtr.contactwebapi.service.address.dtos.AddressDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ContactDTO {

    @NotBlank(message = "You must provide a firstName")
    private String firstName;
    @NotBlank(message = "You must provide a lastName")
    private String lastName;
    @NotNull(message = "You must provide an address")
    private AddressDTO address;
    @NotNull(message = "You must provide a contactType")
    private ContactType contactType;

    private String numVAT;

    public ContactDTO() {}

    public ContactDTO(String firstName, String lastName, AddressDTO address, ContactType contactType, String numVAT) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setContactType(contactType);
        setNumVAT(numVAT);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }

    public String getNumVAT() {
        return numVAT;
    }

    public void setNumVAT(String numVAT) {
        this.numVAT = numVAT;
    }

    @JsonIgnore
    @AssertTrue(message = "numVAT is required for Freelance contacts")
    public boolean isNumVATValid() {
        if (this.contactType == ContactType.FREELANCE) {
            return this.numVAT != null && !this.numVAT.isEmpty();
        }
        return true;
    }
}
