package ch.fhnw.module.medipokev1.Data.Repository;

import ch.fhnw.module.medipokev1.Data.Domain.Medication;
import ch.fhnw.module.medipokev1.Data.Domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    //Schedule findByDuplicate(Long Id, Medication medication);
    Schedule findByIdAndMedication(Long Id, Medication medication);
}
