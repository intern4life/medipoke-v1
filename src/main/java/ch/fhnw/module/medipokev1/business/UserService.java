package ch.fhnw.module.medipokev1.business;

import ch.fhnw.module.medipokev1.Data.Domain.User;
import ch.fhnw.module.medipokev1.Data.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User addUser(User user) throws Exception {

        if(user.getFirstName() != null) {
            if (userRepository.findByEmail(user.getEmail()) == null || userRepository.findByPhoneNumber(user.getPhoneNumber()) == null)
                return userRepository.save(user);
            throw new Exception("User " + user.getFirstName() + " " + user.getLastName() +" with the birthdate " + user.getDateOfBirth() + " already exists");
        }
        throw new Exception("Invalid user entry");
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        try {
            return userRepository.findById(id).get();
        } catch (Exception e) {
            throw new RuntimeException("User with id " + id + " not found");
        }
    }
}
