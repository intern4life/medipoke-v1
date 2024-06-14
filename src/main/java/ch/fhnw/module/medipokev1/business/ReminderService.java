package ch.fhnw.module.medipokev1.business;


import ch.fhnw.module.medipokev1.Data.Domain.Reminder;
import ch.fhnw.module.medipokev1.Data.Repository.ReminderRepository;
import ch.fhnw.module.medipokev1.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;


    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }

    /* TODO findRemindersById
    public Reminder findRemindersById(Long id) {}
    */

    public Reminder addReminder(Reminder reminder) throws Exception {
        if (reminder.getMessage() != null){
            if (reminderRepository.findByMessage(reminder.getMessage()) == null)
                return reminderRepository.save(reminder);
            throw new Exception("Reminder \"" + reminder.getMessage() + "\" already exists");
        }
        throw new Exception("Invalid reminder entry");
    }

    /* TODO deleteReminder
    public void deleteReminder(Long id) throws Exception {
    }
    */
}
