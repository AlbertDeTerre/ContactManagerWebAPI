package com.albertvtr.contactwebapi.model.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends Contact{

    public Employee(){
        super();
        setContactType(ContactType.EMPLOYEE);
    }

    public Employee(String firstName, String lastName, Address address) {
        super(firstName, lastName, address, ContactType.EMPLOYEE);
    }
}
