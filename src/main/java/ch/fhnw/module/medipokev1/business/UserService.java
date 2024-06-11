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
            if (userRepository.findByFirstName(user.getFirstName()) == null)
                return userRepository.save(user);
            throw new Exception("User " + user.getFirstName() + " already exists");
        }
        throw new Exception("Invalid user name");
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
