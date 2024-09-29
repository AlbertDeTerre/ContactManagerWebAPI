package com.albertvtr.contactwebapi.service.contact;

import com.albertvtr.contactwebapi.service.contact.dtos.ContactDTOInput;
import com.albertvtr.contactwebapi.service.contact.dtos.ContactDTOOutput;

import java.util.List;

public interface ContactService {

    ContactDTOOutput createContact(ContactDTOInput contact);
    ContactDTOOutput updateContact(ContactDTOInput contact, Long id);
    void deleteContact(Long id);
    List<ContactDTOOutput> fetchAllContacts();
}
