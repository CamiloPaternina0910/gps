package com.unicordoba.gps.contact.model;

import java.io.Serializable;

import com.unicordoba.gps.user.model.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "contacts")
@Getter
@Setter
public class Contact implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    @NotEmpty(message = "Phone is required")
    private String phone;

    @Email(message = "Format not support")
    @NotEmpty(message = "Email is required")
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
