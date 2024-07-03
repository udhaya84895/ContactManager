package com.example.contactmanagement.model;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Id;


@Entity
@Table(name = "Cantacts")
@Getter
@Setter
public class ContactSaver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "Name", unique = false, nullable = false, length = 50)
    private String name;
    @Column(name = "PhoneNumber", unique = true, nullable = false, length = 10)
    private String phone;
    @Column(name = "Email", unique = true, nullable = false, length = 100)
    private String email;
    @Column(name = "Description")
    private String description;

    public ContactSaver(){

    }
    public ContactSaver(String name, String phone, String email, String desc){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.description = desc;
    }

}
