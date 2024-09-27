package com.albertvtr.contactwebapi.service.contact;

import com.albertvtr.contactwebapi.model.entities.Contact;
import com.albertvtr.contactwebapi.model.repos.ContactRepository;
import com.albertvtr.contactwebapi.service.contact.dtos.ContactDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService{

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    public ContactServiceImpl(ContactRepository contactRepository, ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ContactDTO createContact(ContactDTO contact) {
        // Map the contact dto to an entity
        Contact createdContact = modelMapper.map(contact, Contact.class);

        // Set id to null to avoid updating an existing contact
        createdContact.setId(null);

        // Save contact as entity and return it as DTO
        return modelMapper.map(contactRepository.save(createdContact), ContactDTO.class);
    }

    @Override
    public ContactDTO updateContact(ContactDTO contact, Long id) {

        // Find contact into the db
        Contact contactDB = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));

        // If contact type has to be modified, contact of DB has to be deleted then recreated with the right instance
        if (contact.getContactType() != contactDB.getContactType()) {
            contactRepository.deleteById(contactDB.getId()); // TODO: PEUT CAUSER UN PROBLEME ET ENLEVER LE CONTACT DE LA COMPANY
        }

        // Update contact fields
        contactDB = modelMapper.map(contact, Contact.class);

        ContactDTO updatedContact = modelMapper.map(contactRepository.save(contactDB), ContactDTO.class);

        // TODO: CHANGE CONNECTION WITH COMPANIES

        // Save the updated entity and return it as DTO
        return updatedContact;
    }

    @Override
    public void deleteContact(Long id) {
        // Find the user to delete and delete if it exists
        Contact contactDB = contactRepository.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
        contactRepository.delete(contactDB);
    }

    @Override
    public List<ContactDTO> fetchAllContacts() {

        // Retrieve all contact entities
        List<Contact> contacts = contactRepository.findAll();

        // Return mapped contacts
        return modelMapper.map(contacts, new TypeToken<List<ContactDTO>>() {}.getType());
    }
}
