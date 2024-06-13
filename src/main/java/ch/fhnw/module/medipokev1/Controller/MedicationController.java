package ch.fhnw.module.medipokev1.Controller;

import ch.fhnw.module.medipokev1.Data.Domain.Medication;
import ch.fhnw.module.medipokev1.Data.Domain.User;
import ch.fhnw.module.medipokev1.business.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController

public class MedicationController {

    @Autowired
    private MedicationService medicationService;

    @GetMapping(path="/medications", produces = "application/json")
    public List<Medication> getMedicationsList() {
        return medicationService.getAllMedications();
    }

    @PostMapping(path="/medications/create", consumes="application/json", produces = "application/json")
    public ResponseEntity addMedication(@RequestBody Medication medication) {
        try{
            medication = medicationService.addMedication(medication);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Medication already exists with given chemical substance");
        }
        return ResponseEntity.ok(medication);
    }

    @GetMapping(path="/medications/{id}", produces = "application/json")
    public ResponseEntity findMedicationById(@PathVariable Long id) {
        try{
            Medication medication = medicationService.findMedicationById(id);
            return ResponseEntity.ok(medication);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No medication found with given id");
        }
    }
}
