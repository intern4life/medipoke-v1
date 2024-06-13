package ch.fhnw.module.medipokev1.business;

import ch.fhnw.module.medipokev1.Data.Domain.Medication;
import ch.fhnw.module.medipokev1.Data.Domain.User;
import ch.fhnw.module.medipokev1.Data.Repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {

    @Autowired
    private MedicationRepository medicationRepository;

    public Medication addMedication(Medication medication) throws Exception {
        if (medication.getChemicalSubstance() != null) {
            if (medicationRepository.findByChemicalSubstance(medication.getChemicalSubstance()) == null)
                return medicationRepository.save(medication);
            throw new Exception("Medication with the chemical substance " + medication.getChemicalSubstance() + " already exists");
        }
        throw new Exception("Invalid medication entry");
    }

    public List<Medication> getAllMedications() {
        return medicationRepository.findAll();
    }

    public Medication findMedicationById(Long id) {
        try {
            return medicationRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("Medication with id " + id + " not found");
        }
    }
}
