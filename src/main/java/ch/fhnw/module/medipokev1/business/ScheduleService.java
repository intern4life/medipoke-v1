package ch.fhnw.module.medipokev1.business;

import ch.fhnw.module.medipokev1.Data.Domain.Schedule;
import ch.fhnw.module.medipokev1.Data.Repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<Schedule> getAllSchedules(){return scheduleRepository.findAll();}

    public Schedule addSchedule(Schedule schedule) throws Exception {
        if (schedule.getPatientId() != null){
            if (scheduleRepository.findByIdAndMedication(schedule.getId(),schedule.getMedication()) == null)
                return scheduleRepository.save(schedule);
            throw new Exception("Scheduled medication " + schedule.getMedication().getBrand() + " for patient with the user ID {" + schedule.getPatientId() + "} already exists");
        }
        throw new Exception("Invalid schedule entry");
    }

    public void deleteSchedule(Long id) throws Exception {
        if(scheduleRepository.existsById(id)) {
            scheduleRepository.deleteById(id);
        } else
            throw new Exception("Schedule with id " + id + " does not exist");
    }
}
