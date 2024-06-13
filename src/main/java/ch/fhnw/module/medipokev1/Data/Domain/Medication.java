package ch.fhnw.module.medipokev1.Data.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;

@Entity
@Table(name = "medication")
public class Medication {
    public enum DistributionCategory{
        A,
        B,
        C,
        D,
        E,
        F
    }

    public enum AdministrationType {
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "side_effects")
    private String sideEffects;
    @Column(name = "distribution_category")
    private DistributionCategory distributionCategory;
    @Column(name = "administration_type")
    private AdministrationType administrationType;
    @Column(name = "weight")
    private String weight;
    @Column(name = "brand")
    private String brand;
    @Column(name = "chemical_substance")
    private String chemicalSubstance;

    public Medication(String sideEffects, Medication.DistributionCategory distributionCategory, Medication.AdministrationType administrationType, String weight, String brand, String chemicalSubstance) {
        this.sideEffects = sideEffects;
        this.distributionCategory = distributionCategory;
        this.administrationType = administrationType;
        this.weight = weight;
        this.brand = brand;
        this.chemicalSubstance = chemicalSubstance;
    }

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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getChemicalSubstance() {
        return chemicalSubstance;
    }

    public void setChemicalSubstance(String chemicalSubstance) {
        this.chemicalSubstance = chemicalSubstance;
    }

    public Medication() {

    }

}
