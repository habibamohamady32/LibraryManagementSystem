package ngo.springframework.librarymangementsystem.service;

import ngo.springframework.librarymangementsystem.DTOs.AuthorDTO;
import ngo.springframework.librarymangementsystem.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    Author createAuthor(Author author);
    Optional<AuthorDTO> getAuthorById(Long id);
    List<AuthorDTO> getAllAuthors();
    Author updateAuthor(Long id, Author author);
    void deleteAuthor(Long id);
}
