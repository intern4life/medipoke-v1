package ch.fhnw.module.medipokev1.Data.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "medication")
public class Medication {
    private enum DistributionCategory{
        A,
        B,
        C,
        D,
        E,
        F
    }

    private enum AdministrationType {
        TABLETS,
        CAPSULES,
        SUBLINGUAL,
        EAR_DROPS,
        EYE_DROPS,
        TRANSDERMAL,
        NASAL,
        INJECTION
    }
    @Id
    @JsonIgnore
    private Long id;
    private String sideEffects;
    private DistributionCategory distributionCategory;
    private AdministrationType administrationType;
    private String weight;
    @OneToOne
    private Brand brand;
    @OneToOne
    private ChemicalSubstance chemicalSubstance;
    @OneToMany
    private Schedule schedule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public DistributionCategory getDistributionCategory() {
        return distributionCategory;
    }

    public void setDistributionCategory(DistributionCategory distributionCategory) {
        this.distributionCategory = distributionCategory;
    }

    public AdministrationType getAdministrationType() {
        return administrationType;
    }

    public void setAdministrationType(AdministrationType administrationType) {
        this.administrationType = administrationType;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public ChemicalSubstance getChemicalSubstance() {
        return chemicalSubstance;
    }

    public void setChemicalSubstance(ChemicalSubstance chemicalSubstance) {
        this.chemicalSubstance = chemicalSubstance;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
