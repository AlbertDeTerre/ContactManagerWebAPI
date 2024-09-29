package com.albertvtr.contactwebapi.model.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Address address;
    private String numVAT;

    /*@Transient
    private ContactType contactType;*/

    @ManyToMany(mappedBy = "contacts", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<Company> companies;

    public Contact() {}

    public Contact(String firstName, String lastName, Address address/*, ContactType contactType*/, String numVAT) {
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        //setContactType(contactType);
        setNumVAT(numVAT);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /*public ContactType getContactType() {
        return contactType;
    }

    public void setContactType(ContactType contactType) {
        this.contactType = contactType;
    }*/

    public List<Company> getCompanies() {
        return companies;
    }

    public String getNumVAT() {
        return numVAT;
    }

    public void setNumVAT(String numVAT) {
        this.numVAT = numVAT;
        /*if (this.numVAT.isBlank()){
            setContactType(ContactType.FREELANCE);
        }else{
            setContactType(ContactType.EMPLOYEE);
        }*/
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(id, contact.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
