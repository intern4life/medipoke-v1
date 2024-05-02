package ch.fhnw.module.medipokev1.data.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chemical_substance")
public class ChemicalSubstance {
    @Id
    @JsonIgnore
    private Long id;
}
