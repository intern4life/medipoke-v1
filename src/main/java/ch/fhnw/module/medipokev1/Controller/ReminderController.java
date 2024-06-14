package ch.fhnw.module.medipokev1.Controller;

import ch.fhnw.module.medipokev1.Data.Domain.Reminder;
import ch.fhnw.module.medipokev1.business.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @GetMapping(path="/reminders", produces = "application/json")
    public List<Reminder> getReminderList() {
        return reminderService.getAllReminders();
    }
}
