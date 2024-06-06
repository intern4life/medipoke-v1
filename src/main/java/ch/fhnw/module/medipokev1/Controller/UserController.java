package ch.fhnw.module.medipokev1.Controller;

import ch.fhnw.module.medipokev1.Data.Domain.ContactDetails;
import ch.fhnw.module.medipokev1.Data.Domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(path="/user", produces = "application/json")
    public ResponseEntity getUserList() {
        List<User> userList = new ArrayList();

        User user1 =  new User(1L, "Jon", "Wick", User.UserRole.ADMIN, "Thu Jun 06 16:17:55 CEST 2000", User.Gender.MALE, new ContactDetails(1L,"jon@wick.ch", "+41 79 444 44 33"));

        userList.add(user1);
        if(userList.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userList);
    }
}
