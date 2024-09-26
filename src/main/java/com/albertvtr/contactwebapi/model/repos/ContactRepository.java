package com.albertvtr.contactwebapi.model.repos;

import com.albertvtr.contactwebapi.model.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> { }