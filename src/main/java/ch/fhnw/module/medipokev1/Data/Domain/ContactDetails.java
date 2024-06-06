package ch.fhnw.module.medipokev1.Data.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;

@Entity
public class ContactDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "id", nullable = false)
    private Long id;

    private String contactEmail;

    private String phoneNumber;

    public Long getId() {
        return id;
    }

    public ContactDetails(Long id, String contactEmail, String phoneNumber) {
        this.id = id;
        this.contactEmail = contactEmail;
        this.phoneNumber = phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
