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

}
