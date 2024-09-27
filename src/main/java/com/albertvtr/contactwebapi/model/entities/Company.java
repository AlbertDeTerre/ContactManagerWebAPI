package com.albertvtr.contactwebapi.model.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numVAT;
    private Address address;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "company_contact",
            joinColumns = @JoinColumn(name = "company_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id")
    )
    private List<Contact> contacts;

    public Company() {}
    public Company(String numVAT, Address address) {
        this.numVAT = numVAT;
        this.address = address;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNumVAT() {
        return numVAT;
    }

    public void setNumVAT(String numVAT) {
        this.numVAT = numVAT;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}