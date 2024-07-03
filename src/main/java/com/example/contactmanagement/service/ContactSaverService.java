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

    public List<String> getAllByName(String name) {
        List<ContactSaver> contacts = (List<ContactSaver>) contactSaverRepository.findAllByName(name);

        // Check if contacts list is not null and not empty
        if (!contacts.isEmpty()) {
            List<String> names = contacts.stream()
                    .map(ContactSaver::getName)
                    .collect(Collectors.toList());

            return names;
        } else {
            return new ArrayList<>();
        }
    }
}
