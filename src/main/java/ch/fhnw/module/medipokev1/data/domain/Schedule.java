package ch.fhnw.module.medipokev1.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Schedule {
    @Id
    @JsonIgnore
    private Long id;
}
