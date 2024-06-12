package ch.fhnw.module.medipokev1.Controller;

import ch.fhnw.module.medipokev1.Data.Domain.User;
import ch.fhnw.module.medipokev1.business.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path="/users", produces = "application/json")
    public List<User> getUserList() {
        return userService.getAllUsers();
    }

    @PostMapping(path="/users/create", consumes="application/json", produces = "application/json")
    public ResponseEntity addUser(@RequestBody User user) {
        try{
            user = userService.addUser(user);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists with given name");
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping(path="/users/{id}", produces = "application/json")
    public ResponseEntity findUserById(@PathVariable Long id) {
        try{
            User user = userService.findUserById(id);
            return ResponseEntity.ok(user);
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No user found with given id");
        }
    }

    @PutMapping(path="/users/{id}/update", consumes="application/json", produces = "application/json")
    public ResponseEntity updateUser(@PathVariable Long id, @RequestBody User user) {
        try{
            user = userService.updateUser(id, user);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("No user found with given id");
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping(path="/users/{id}/delete")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try{
            userService.deleteUser(id);
            return ResponseEntity.ok("User with id " + id + " deleted");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
}
