package com.example.contactmanagement.repository;

import com.example.contactmanagement.model.ContactSaver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactSaverRepository extends JpaRepository <ContactSaver, Long>{

    List<ContactSaver> findAllByName(String name);
}
