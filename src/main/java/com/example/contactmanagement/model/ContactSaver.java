package model;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "Cantacts")

public class ContactSaver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "Name", unique = false, nullable = false, length = 50)
    private String Name;
    @Column(name = "PhoneNumber", unique = true, nullable = false, length = 10)
    private String Phone;
    @Column(name = "Email", unique = true, nullable = false, length = 100)
    private String Email;
    @Column(name = "Description")
    private String description;

    public ContactSaver(){

    }
    public ContactSaver(String name, String phone, String email, String desc){
        this.Name = name;
        this.Phone = phone;
        this.Email = email;
        this.description = desc;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
