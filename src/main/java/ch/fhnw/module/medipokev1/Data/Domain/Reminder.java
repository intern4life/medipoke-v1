package ch.fhnw.module.medipokev1.Data.Domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "reminder")
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "id", nullable = false)
    private Long id;

    //@ManyToOne
    //@JoinColumn(name = "user_id")
    @Column(name = "patient_Id")
    private Long patientId;

    @Column(name = "reminder_timestamp", nullable = false, updatable = false)
    @CreationTimestamp
    private Date timestamp;

    @Column(name = "message")
    private String message;

    public Reminder (String message, Long patientId){
        this.message = message;
        this.patientId = patientId;
    }

    public Reminder (){

    }

    public Long getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
