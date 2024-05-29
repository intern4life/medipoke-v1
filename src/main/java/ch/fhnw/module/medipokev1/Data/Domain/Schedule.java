package ch.fhnw.module.medipokev1.Data.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Schedule {
    @Id
    @JsonIgnore
    private Long id;

    private Long schedulePatientID;

    private Long scheduleMedicationID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSchedulePatientID() {
        return schedulePatientID;
    }

    public void setSchedulePatientID(Long schedulePatientID) {
        this.schedulePatientID = schedulePatientID;
    }

    public Long getScheduleMedicationID() {
        return scheduleMedicationID;
    }

    public void setScheduleMedicationID(Long scheduleMedicationID) {
        this.scheduleMedicationID = scheduleMedicationID;
    }
}
