package com.albertvtr.contactwebapi.controller;

import com.albertvtr.contactwebapi.service.company.CompanyService;
import com.albertvtr.contactwebapi.service.company.dtos.AddContactToCompanyDTO;
import com.albertvtr.contactwebapi.service.company.dtos.CompanyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("{numVAT}")
    public ResponseEntity<CompanyDTO> fetchCompanyByVAT(@PathVariable String numVAT) {
        return ResponseEntity.ok(companyService.fetchCompanyByVATNumber(numVAT));
    }

    @PutMapping
    public ResponseEntity<CompanyDTO> updateCompany(@RequestBody CompanyDTO companyDTO, Long id) {
        return ResponseEntity.ok(companyService.UpdateCompany(companyDTO, id));
    }

    @PostMapping
    public ResponseEntity<CompanyDTO> createCompany(@RequestBody CompanyDTO companyDTO) {
        return ResponseEntity.ok(companyService.createCompany(companyDTO));
    }

    @GetMapping
    public ResponseEntity<List<CompanyDTO>> fetchAllCompanies() {
        return ResponseEntity.ok(companyService.fetchAllCompanies());
    }

    @PostMapping("/addContactToCompany")
    public ResponseEntity<Void> addContactToCompany(@RequestBody AddContactToCompanyDTO addContactToCompanyDTO) {
        companyService.addContactToCompany(addContactToCompanyDTO.getContactId(), addContactToCompanyDTO.getCompanyId());
        return ResponseEntity.noContent().build();
    }
}
