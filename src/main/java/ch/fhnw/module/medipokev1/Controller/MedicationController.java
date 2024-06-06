package ch.fhnw.module.medipokev1.Controller;

import ch.fhnw.module.medipokev1.Data.Domain.Medication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class MedicationController {

    //get list of medications
    @RequestMapping(path="/medication", produces = "application/json")
    public ResponseEntity getPizzaList() {
        List<Medication> medicationList = new ArrayList();

        Medication medication1 = new Medication();
        medication1.setId(1L);
        medication1.setWeight("1g");
        medication1.setAdministrationType(Medication.AdministrationType.TABLETS);
        medication1.setChemicalSubstance("Paracetamol");
        medication1.setBrand("Dafalgan");
        medication1.setDistributionCategory(Medication.DistributionCategory.B);
        medication1.setSideEffects("Mild to non-existent");

        medicationList.add(medication1);
        if(medicationList.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(medicationList);
    }
}
