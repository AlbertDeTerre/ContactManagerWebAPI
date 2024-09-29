package com.albertvtr.contactwebapi.service.company.dtos;

import com.albertvtr.contactwebapi.service.address.dtos.AddressDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CompanyDTO {

    private Long id;

    @NotBlank(message = "You must provide a numVAT")
    private String numVAT;

    @NotNull(message = "You must provide an address")
    private AddressDTO address;

    public CompanyDTO() {}

    public CompanyDTO(Long id, String numVAT, AddressDTO address) {
        setId(id);
        setNumVAT(numVAT);
        setAddress(address);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumVAT() {
        return numVAT;
    }

    public void setNumVAT(String numVAT) {
        this.numVAT = numVAT;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }
}
