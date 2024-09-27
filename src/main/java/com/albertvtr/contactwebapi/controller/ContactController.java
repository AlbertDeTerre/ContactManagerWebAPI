package com.albertvtr.contactwebapi.controller;

import com.albertvtr.contactwebapi.service.contact.ContactService;
import com.albertvtr.contactwebapi.service.contact.dtos.ContactDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<ContactDTO>> fetchAllContacts(){
        return ResponseEntity.ok(contactService.fetchAllContacts());
    }

    @PostMapping
    public ResponseEntity<ContactDTO> createContact(@Valid @RequestBody ContactDTO contactDTO){

        return ResponseEntity.ok(contactService.createContact(contactDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactDTO> updateContact(@Valid @RequestBody ContactDTO contactDTO, @PathVariable Long id){
        return ResponseEntity.ok(contactService.updateContact(contactDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id){
        contactService.deleteContact(id);
        return null;
    }

}
