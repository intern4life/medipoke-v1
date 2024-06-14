package ch.fhnw.module.medipokev1.Data.Domain;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;

@Entity
@Table(name = "reminder")
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Hidden
    @Column(name = "id", nullable = false)
    private Long id;



}
