package ch.fhnw.module.medipokev1.Data.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;

@Entity
@Table(name = "chemical_substance")
public class ChemicalSubstance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "chemical_name")
    private String chemicalName;
    @Column(name = "abbreviated_name")
    private String abbreviatedName;

    public ChemicalSubstance(String chemicalName, String abbreviatedName){
        this.chemicalName = chemicalName;
        this.abbreviatedName = abbreviatedName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChemicalName() {
        return chemicalName;
    }

    public void setChemicalName(String chemicalName) {
        this.chemicalName = chemicalName;
    }

    public String getAbbreviatedName() {
        return abbreviatedName;
    }

    public void setAbbreviatedName(String abbreviatedName) {
        this.abbreviatedName = abbreviatedName;
    }
}
