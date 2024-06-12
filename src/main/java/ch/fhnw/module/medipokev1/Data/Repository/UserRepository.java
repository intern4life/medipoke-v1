package ch.fhnw.module.medipokev1.Data.Repository;

import ch.fhnw.module.medipokev1.Data.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByFirstName(String firstName);

    User findByLastName(String lastName);
    User findByDateOfBirth(String dateOfBirth);

    User findByEmail(String email);
    User findByPhoneNumber(String phoneNumber);
    //List<User> findAllByUserContainsIgnoreCase(String tmp);
}
