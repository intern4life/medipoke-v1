package ch.fhnw.module.medipokev1.Controller;

import ch.fhnw.module.medipokev1.Data.Domain.Medication;
import ch.fhnw.module.medipokev1.Data.Domain.Schedule;
import ch.fhnw.module.medipokev1.business.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @GetMapping(path="/schedules", produces = "application/json")
    public List<Schedule> getScheduleList(){
        return scheduleService.getAllSchedules();
    }

    @PostMapping(path="/schedules/create", consumes="application/json", produces = "application/json")
    public ResponseEntity addSchedule(@RequestBody Schedule schedule) {
        try{
            schedule = scheduleService.addSchedule(schedule);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Schedule already exists with given patient ID and medication");
        }
        return ResponseEntity.ok(schedule);
    }

    @DeleteMapping(path="/schedules/{id}/delete")
    public ResponseEntity<String> deleteSchedule(@PathVariable Long id) {
        try{
            scheduleService.deleteSchedule(id);
            return ResponseEntity.ok("Schedule with id " + id + " deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Schedule not found");
        }
    }

}
