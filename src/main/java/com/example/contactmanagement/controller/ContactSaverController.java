package com.example.contactmanagement.controller;

import com.example.contactmanagement.dto.ContactSaverRequestDto;

import com.example.contactmanagement.service.ContactSaverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
    public List<String> getContact(@RequestParam String name){
        return contactSaverService.getAllByName(name);
    }
}
