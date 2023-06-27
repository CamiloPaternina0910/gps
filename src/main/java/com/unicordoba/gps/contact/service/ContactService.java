package com.unicordoba.gps.contact.service;

import java.util.List;

import com.unicordoba.gps.contact.model.Contact;

public interface ContactService {
    
    List<Contact> findAll();

    Contact findById(Long id);

    void save(Contact contact);

    void delete(Contact contact);

}
