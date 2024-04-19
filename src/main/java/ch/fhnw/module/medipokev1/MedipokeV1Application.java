package ch.fhnw.module.medipokev1;

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

}
