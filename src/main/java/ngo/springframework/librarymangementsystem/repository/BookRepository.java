package ngo.springframework.librarymangementsystem.repository;

import ngo.springframework.librarymangementsystem.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor_Name(String authorName);
    List<Book> findByCategory_Name(String categoryName);
    List<Book> findByAuthor_NameAndCategory_Name(String authorName, String categoryName);
}



