package com.unicordoba.gps.contact.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unicordoba.gps.contact.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{
    
}
