package ch.fhnw.module.medipokev1.Data.Repository;

import ch.fhnw.module.medipokev1.Data.Domain.ChemicalSubstance;
import ch.fhnw.module.medipokev1.Data.Domain.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

        Medication findByChemicalSubstance(ChemicalSubstance chemicalSubstance);

        //List<Medication> findBySomething(String tmp);
}
