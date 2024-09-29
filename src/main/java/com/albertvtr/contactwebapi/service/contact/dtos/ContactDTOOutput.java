package com.albertvtr.contactwebapi.service.contact.dtos;

import com.albertvtr.contactwebapi.model.entities.ContactType;
import com.albertvtr.contactwebapi.service.address.dtos.AddressDTO;

public class ContactDTOOutput {

    private Long id;
    private String firstName;
    private String lastName;
    private AddressDTO address;
    private ContactType contactType;

    private String numVAT;

    public ContactDTOOutput() {}

    public ContactDTOOutput(Long id, String firstName, String lastName, AddressDTO address, ContactType contactType, String numVAT) {
        setId(id);
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
        if (!getNumVAT().isBlank()) {
            setContactType(ContactType.FREELANCE);
        }else{
            setContactType(ContactType.EMPLOYEE);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
