package com.example.contactmanagement.service;

import com.example.contactmanagement.dto.ContactSaverRequestDto;
import com.example.contactmanagement.model.ContactSaver;
import com.example.contactmanagement.repository.ContactSaverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactSaverService {

    @Autowired
    ContactSaverRepository contactSaverRepository;

    public void saveContact(ContactSaverRequestDto contactSaverRequestDto) {
      String name = contactSaverRequestDto.getName();
      String email = contactSaverRequestDto.getEmail();
      String phone = contactSaverRequestDto.getPhone();
      String description = contactSaverRequestDto.getDescription();

      ContactSaver contactSaver = new ContactSaver(name, phone, email, description);
        contactSaverRepository.save(contactSaver);

    }

    public List<ContactSaver> getAllByName(String name) {
        List<ContactSaver> contacts =  contactSaverRepository.findAllByName(name);
        if(contacts.isEmpty()){
            return new ArrayList<>();
        }else {
            return contacts;
        }
    }
}
