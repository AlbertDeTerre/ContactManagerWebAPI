package com.albertvtr.contactwebapi.model.entities;

public class Freelance extends Contact {

    private String numVAT;

    public Freelance(){
        super();
        setContactType(ContactType.FREELANCE);
    }

    public Freelance(String firstName, String lastName, Address address, String numVAT) {
        super(firstName, lastName, address, ContactType.FREELANCE);
        setNumVAT(numVAT);
    }

    public String getNumVAT() {
        return numVAT;
    }

    public void setNumVAT(String numVAT) {
        this.numVAT = numVAT;
    }
}
