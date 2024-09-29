package com.albertvtr.contactwebapi.service.contact;

import com.albertvtr.contactwebapi.model.entities.Address;
import com.albertvtr.contactwebapi.model.entities.Company;
import com.albertvtr.contactwebapi.model.entities.Contact;
import com.albertvtr.contactwebapi.model.repos.ContactRepository;
import com.albertvtr.contactwebapi.service.company.CompanyService;
import com.albertvtr.contactwebapi.service.contact.dtos.ContactDTOInput;
import com.albertvtr.contactwebapi.service.contact.dtos.ContactDTOOutput;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;
    private final CompanyService companyService;

    public ContactServiceImpl(ContactRepository contactRepository, ModelMapper modelMapper, CompanyService companyService) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
        this.companyService = companyService;
    }

    @Override
    public ContactDTOOutput createContact(ContactDTOInput contact) {
        // Map the contact dto to an entity
        Contact createdContact = modelMapper.map(contact, Contact.class);

        // Set id to null to avoid updating an existing contact
        createdContact.setId(null);

        // Save contact as entity and return it as DTO
        return modelMapper.map(contactRepository.save(createdContact), ContactDTOOutput.class);
    }

    @Override
    public ContactDTOOutput updateContact(ContactDTOInput contact, Long id) {
        // Find contact into the db
        Contact contactDB = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));

        // Update the contact fields
        contactDB.setFirstName(contact.getFirstName());
        contactDB.setLastName(contact.getLastName());
        contactDB.setAddress(modelMapper.map(contact.getAddress(), Address.class));
        contactDB.setNumVAT(contact.getNumVAT());

        // Save the updated entity and return it as DTO
        return modelMapper.map(contactRepository.save(contactDB), ContactDTOOutput.class);
    }

    @Override
    public void deleteContact(Long id) {
        // Find the user to delete and delete if it exists
        Contact contactDB = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));

        // Remove contact from all
        for (Company company : contactDB.getCompanies()){
            companyService.removeContactFromCompany(contactDB.getId(), company.getId());
        }

        contactRepository.delete(contactDB);
    }

    @Override
    public List<ContactDTOOutput> fetchAllContacts() {

        // Retrieve all contact entities
        List<Contact> contacts = contactRepository.findAll();

        // Return mapped contacts
        return modelMapper.map(contacts, new TypeToken<List<ContactDTOOutput>>() {}.getType());
    }
}
