package com.albertvtr.contactwebapi.service.company;

import com.albertvtr.contactwebapi.service.company.dtos.CompanyDTO;

import java.util.List;

public interface CompanyService {
    CompanyDTO createCompany(CompanyDTO companyDTO);
    CompanyDTO UpdateCompany(CompanyDTO companyDTO, Long id);
    CompanyDTO fetchCompanyByVATNumber(String numVAT);
    List<CompanyDTO> fetchAllCompanies();
    void addContactToCompany(Long contactId, Long companyId);
    void removeContactFromCompany(Long contactId, Long companyId);
}