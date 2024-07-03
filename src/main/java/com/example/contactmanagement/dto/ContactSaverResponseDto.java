package com.example.contactmanagement.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactSaverResponseDto {
    private String name;
    private String phone;
    private String email;
    private String description;
}
