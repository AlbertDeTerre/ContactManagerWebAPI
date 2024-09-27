package com.albertvtr.contactwebapi.service.contact;

import com.albertvtr.contactwebapi.service.contact.dtos.ContactDTO;

import java.util.List;

public interface ContactService {

    ContactDTO createContact(ContactDTO contact);
    ContactDTO updateContact(ContactDTO contact, Long id);
    void deleteContact(Long id);
    List<ContactDTO> fetchAllContacts();
}
