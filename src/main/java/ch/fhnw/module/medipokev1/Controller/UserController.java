package ch.fhnw.module.medipokev1.Controller;

import ch.fhnw.module.medipokev1.Data.Domain.User;
import ch.fhnw.module.medipokev1.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /*
    @RequestMapping(path="/user", produces = "application/json")

    public ResponseEntity getUserList() {
        List<User> userList = new ArrayList();

        User user1 =  new User(0L, "Jon", "Wick", User.UserRole.ADMIN, "Thu Jun 06 16:17:55 CEST 2000", User.Gender.MALE, "jon@wick.ch", "+41 79 444 44 33");
        User user2 =  new User(1L, "Jane", "Beautist", User.UserRole.PATIENT, "Thu Jun 06 16:17:55 CEST 1990", User.Gender.FEMALE, "jane@beautist.ch", "+41 79 666 70 00");
        userList.add(user1);
        userList.add(user2);

        if(userList.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(userList);
    }
     */

    @GetMapping(path="/user", produces = "application/json")
    public List<User> getUserList() {
        return userService.getAllUsers();
    }

    @PostMapping(path="/user/create", consumes="application/json", produces = "application/json")
    public ResponseEntity addUser(@RequestBody User user) {
        try{
            user = userService.addUser(user);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists with given name");
        }
        return ResponseEntity.ok(user);
    }

}
