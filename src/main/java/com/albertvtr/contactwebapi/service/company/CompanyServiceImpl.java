package com.albertvtr.contactwebapi.service.company;

import com.albertvtr.contactwebapi.model.entities.Company;
import com.albertvtr.contactwebapi.model.entities.Contact;
import com.albertvtr.contactwebapi.model.repos.CompanyRepository;
import com.albertvtr.contactwebapi.model.repos.ContactRepository;
import com.albertvtr.contactwebapi.service.company.dtos.CompanyDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    public CompanyServiceImpl(CompanyRepository companyRepository, ModelMapper modelMapper, ContactRepository contactRepository) {
        this.companyRepository = companyRepository;
        this.modelMapper = modelMapper;
        this.contactRepository = contactRepository;
    }

    @Override
    public CompanyDTO createCompany(CompanyDTO companyDTO) {
        // Map dto to company entity
        Company companyDB = modelMapper.map(companyDTO, Company.class);

        // Set id to null to avoid updating an existing company
        companyDB.setId(null);

        // Save and return the created company
        return modelMapper.map(companyRepository.save(companyDB), CompanyDTO.class);
    }

    @Override
    public CompanyDTO UpdateCompany(CompanyDTO companyDTO, Long id) {

        // Check if company exists
        companyRepository.findById(id).orElseThrow(() -> new RuntimeException("Company not found"));

        // Update fields by mapping dto to a company entity
        Company companyDB = modelMapper.map(companyDTO, Company.class);

        // Change id to match the company to update
        companyDB.setId(id);

        // Return the updated company
        return modelMapper.map(companyRepository.save(companyDB), CompanyDTO.class);
    }

    @Override
    public CompanyDTO fetchCompanyByVATNumber(String numVAT) {
        return companyRepository.findByNumVAT(numVAT).map(company -> modelMapper.map(company, CompanyDTO.class)).orElseThrow(() -> new RuntimeException("Company not found"));
    }

    @Override
    public List<CompanyDTO> fetchAllCompanies() {
        for (Company company : companyRepository.findAll()) {
            System.out.println("Company: "+company.getId());
            for (Contact contact : company.getContacts()) {
                System.out.println("    Contact: "+contact.getId());
            }
        }
        return modelMapper.map(companyRepository.findAll(), new TypeToken<List<CompanyDTO>>() {}.getType());
    }

    @Override
    public void addContactToCompany(Long contactId, Long companyId) {

        // Look for the company and the contact
        Company companyDB = companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Company not found"));
        Contact contactDB = contactRepository.findById(contactId).orElseThrow(() -> new RuntimeException("Contact not found"));

        // Add the contact to te company
        companyDB.addContact(contactDB);

        companyRepository.save(companyDB);
    }

    @Override
    public void removeContactFromCompany(Long contactId, Long companyId) {
        // Look for the company and the contact
        Company companyDB = companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Company not found"));
        Contact contactDB = contactRepository.findById(contactId).orElseThrow(() -> new RuntimeException("Contact not found"));

        // Remove the contact from the company
        companyDB.removeContact(contactDB);

        // Save the updated company
        companyRepository.save(companyDB);
    }
}
