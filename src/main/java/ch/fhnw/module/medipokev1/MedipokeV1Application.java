package ch.fhnw.module.medipokev1;

import ch.fhnw.module.medipokev1.Data.Domain.User;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MedipokeV1Application {
    // Comment Nathalie
    // First comment by David Duran
    public static void main(String[] args) {
        SpringApplication.run(MedipokeV1Application.class, args);
    }

    public String message(){
        return "Help";
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

    @PostConstruct
    private void initPlaceholderData() throws Exception {
        //Patient creation
        /*
        User userPatient = new User();
        userPatient.setUserRole(User.UserRole.PATIENT);
        userPatient.setGender(User.Gender.MALE);
        userPatient.setFirstName("John");
        userPatient.setLastName("Doe");
        userPatient.setDateOfBirth(Calendar.);

        User userAdmin = new User();
        userAdmin.setUserRole(User.UserRole.ADMIN);
        userAdmin.setGender(User.Gender.FEMALE);
        userAdmin.setFirstName("Clark");
        userAdmin.setLastName("Kent");
        userAdmin.setDateOfBirth(Calendar.);

         */

        //From refernece project
        /*
        pizza.setPizzaToppings("Tomato sauce, mozzarella, basil");
        menuService.addPizza(pizza);

        pizza = new Pizza();
        pizza.setPizzaName("Funghi");
        pizza.setPizzaToppings("Tomato sauce, mozzarella, mushrooms");
        menuService.addPizza(pizza);
         */
    }

}
