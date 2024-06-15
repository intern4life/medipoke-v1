package ch.fhnw.module.medipokev1;

import ch.fhnw.module.medipokev1.Data.Domain.Medication;
import ch.fhnw.module.medipokev1.Data.Domain.Reminder;
import ch.fhnw.module.medipokev1.Data.Domain.Schedule;
import ch.fhnw.module.medipokev1.Data.Domain.User;
import ch.fhnw.module.medipokev1.business.MedicationService;
import ch.fhnw.module.medipokev1.business.ReminderService;
import ch.fhnw.module.medipokev1.business.ScheduleService;
import ch.fhnw.module.medipokev1.business.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MedipokeV1Application {
    @Autowired
    private UserService userService;
    @Autowired
    private MedicationService medicationService;
    @Autowired
    private ReminderService reminderService;
    @Autowired
    private ScheduleService scheduleService;

    public static void main(String[] args) {
        SpringApplication.run(MedipokeV1Application.class, args);
    }

    @PostConstruct
    private void initPlaceholderData() throws Exception {
        //Users creation
        User user0 =  new User("Jon", "Wick", User.UserRole.ADMIN, "01/06/2000", User.Gender.MALE, "jon@wick.ch", "+41 79 444 44 33");
        User user1 =  new User("Jane", "Beautiste", User.UserRole.PATIENT, "09/10/1990", User.Gender.FEMALE, "jane@beautiste.ch", "+41 79 666 70 00");
        User user2 =  new User("Johanna", "Marley", User.UserRole.ADMIN, "30/12/1974", User.Gender.FEMALE, "johanna@marley.com", "+41 78 563 33 20");
        User user3 =  new User("Bob", "Dillon", User.UserRole.PATIENT, "11/08/2002", User.Gender.MALE, "asdf@ad.de", "+41 78 420 90 33");
        userService.addUser(user0);
        userService.addUser(user1);
        userService.addUser(user2);
        userService.addUser(user3);
        //List<User> userList = new ArrayList();
        //userList.add(user0);
        //userList.add(user1);
        //userList.add(user2);
        //userList.add(user3);

        //Medications creation
        Medication medication0 = new Medication("UPSA Switzerland AG", "Dafalgan", "N-acetyl-para-aminophenol", Medication.AdministrationType.TABLETS, "1000mg", "Stomachache", Medication.DistributionCategory.D);
        Medication medication1 = new Medication("McNeil Consumer Healthcare Ltd", "Tylenol", "N-acetyl-para-aminophenol", Medication.AdministrationType.TABLETS, "500mg", "Stomachache, sleepyness", Medication.DistributionCategory.D);
        Medication medication2 = new Medication("Sanofi Avenits (Schweiz) AG", "Buscopan", "Hyoscine butylbromide", Medication.AdministrationType.TABLETS, "10mg", "Dizziness", Medication.DistributionCategory.C);
        Medication medication3 = new Medication("Andreabal AG", "DuoFer", "Iron-Fumarate, Iron-Gluconate, Vitamin C", Medication.AdministrationType.TABLETS, "1000mg", "Fullness of stomach, pressure in upper stomach, nausea", Medication.DistributionCategory.E);
        medicationService.addMedication(medication0);
        medicationService.addMedication(medication1);
        medicationService.addMedication(medication2);
        medicationService.addMedication(medication3);

        //Notifications creation
        Reminder reminder0 = new Reminder("Hello " + user3.getFirstName() + " " + user3.getLastName() + ", don't forget to take your Dafalgan 1000mg medication before lunch today!", user3.getId());
        Reminder reminder1 = new Reminder("Hello " + user1.getFirstName() + " " + user1.getLastName() + ", don't forget to take your Buscopan 10mg medication before lunch today! You should take it with a glass of water.", user1.getId());
        Reminder reminder2 = new Reminder("Hello " + user3.getFirstName() + " " + user3.getLastName() + ", don't forget to take your Tylenol 500mg medication before dinner today!", user3.getId());
        reminderService.addReminder(reminder0);
        reminderService.addReminder(reminder1);
        reminderService.addReminder(reminder2);

        //Schedule creation
        Schedule schedule0 = new Schedule(user3.getId(),medication0, Schedule.Frequency.BEFORE_LUNCH, "01/03/2024", "30/07/2024");
        Schedule schedule1 = new Schedule(user1.getId(), medication2, Schedule.Frequency.BEFORE_LUNCH, "20/06/2024", "16/10/2024");
        Schedule schedule2 = new Schedule(user3.getId(), medication1, Schedule.Frequency.BEFORE_DINNER, "01/03/2024", "30/07/2024");
        scheduleService.addSchedule(schedule0);
        scheduleService.addSchedule(schedule1);
        scheduleService.addSchedule(schedule2);
    }

    @GetMapping(value="/")
    public String getWelcomeString() {
        return "Hello, welcome to MediPoke!";
    }

    @GetMapping("/nogreeting")
    public String getNogreeting() {
        return "This is not a public greeting";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "This is the admin page. Are you an ADMIN?";
    }
}
