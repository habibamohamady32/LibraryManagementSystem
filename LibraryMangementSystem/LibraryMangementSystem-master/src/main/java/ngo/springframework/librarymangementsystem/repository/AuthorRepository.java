package ngo.springframework.librarymangementsystem.repository;

import ngo.springframework.librarymangementsystem.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface AuthorRepository extends JpaRepository<Author, Long> {

}
