package ch.fhnw.module.medipokev1.Data.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import org.aspectj.lang.annotation.AfterReturning;

@Entity
@Table(name = "schedule")
public class Schedule {

    public enum Frequency{
        DAILY,
        WEEKLY,
        BI_WEEKLY,
        BEFORE_LUNCH,
        AFTER_BREAKFAST,
        BEFORE_DINNER
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @JsonIgnore
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name="patient_id")
    private Long patientId;

    @ManyToOne
    @JoinColumn(name= "medication_id")
    private Medication medication;

    @Column(name="frequency")
    private Frequency frequency;

    @Column(name="schedule_start_date")
    private String startDate;

    @Column(name="schedule_end_date")
    private String endDate;

    public Schedule(Long patientId, Medication medication, Frequency frequency, String startDate, String endDate) {
        this.patientId = patientId;
        this.medication = medication;
        this.frequency = frequency;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Schedule(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
