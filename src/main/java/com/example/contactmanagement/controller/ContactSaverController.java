package com.example.contactmanagement.controller;

import com.example.contactmanagement.dto.ContactSaverRequestDto;

import com.example.contactmanagement.dto.ContactSaverResponseDto;
import com.example.contactmanagement.model.ContactSaver;
import com.example.contactmanagement.service.ContactSaverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactSaverController {
    @Autowired
    ContactSaverService contactSaverService;

    @PostMapping("/save")
    public ResponseEntity<String> saveContact(@RequestBody ContactSaverRequestDto contactSaverRequestDto) {
        contactSaverService.saveContact(contactSaverRequestDto);
        return ResponseEntity.ok("Contact saved Successfully");
    }

    @GetMapping("/get")
    public List<ContactSaverResponseDto> getContact(@RequestParam String name){
         List<ContactSaver> list = contactSaverService.getAllByName(name);
         List<ContactSaverResponseDto> output = new ArrayList<>();;
         for(ContactSaver contactSaver : list){
             ContactSaverResponseDto contactSaverResponseDto = new ContactSaverResponseDto();
             contactSaverResponseDto.setName(contactSaver.getName());
             contactSaverResponseDto.setEmail(contactSaver.getEmail());
             contactSaverResponseDto.setPhone(contactSaver.getPhone());
             output.add(contactSaverResponseDto);
         }
        return output;
    }
}
