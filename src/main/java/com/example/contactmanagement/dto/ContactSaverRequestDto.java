package com.example.contactmanagement.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.PrimitiveIterator;

@Getter
@Setter
public class ContactSaverRequestDto {
    private String name;
    private String phone;
    private String email;
    private String description;
}
