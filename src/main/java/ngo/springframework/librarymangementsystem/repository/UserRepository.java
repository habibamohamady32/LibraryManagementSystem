package ngo.springframework.librarymangementsystem.repository;

import ngo.springframework.librarymangementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
