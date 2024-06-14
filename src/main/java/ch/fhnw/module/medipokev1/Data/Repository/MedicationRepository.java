package ch.fhnw.module.medipokev1.Data.Repository;

import ch.fhnw.module.medipokev1.Data.Domain.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

        Medication findByBrand(String brand);

        //List<Medication> findBySomething(String tmp);
}
