package com.albertvtr.contactwebapi.model.entities;

public class Employee extends Contact{

    public Employee(){
        super();
        setContactType(ContactType.EMPLOYEE);
    }

    public Employee(String firstName, String lastName, Address address) {
        super(firstName, lastName, address, ContactType.EMPLOYEE);
    }
}
