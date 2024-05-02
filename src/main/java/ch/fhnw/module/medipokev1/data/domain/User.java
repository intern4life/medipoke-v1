package ch.fhnw.module.medipokev1.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    public enum UserRole {
        PATIENT,
        ADMIN;
    }

    @Id
    @JsonIgnore
    private Long id;
}
