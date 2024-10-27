package ngo.springframework.librarymangementsystem.service;

import ngo.springframework.librarymangementsystem.DTOs.AuthorDTO;
import ngo.springframework.librarymangementsystem.model.Author;

import java.util.List;

public interface AuthorService {
    Author createAuthor(Author author);
    AuthorDTO getAuthorById(Long id); // Returns AuthorDTO instead of entity
    List<AuthorDTO> getAllAuthors();
    Author updateAuthor(Long id, Author author);
    void deleteAuthor(Long id);
    Author findById(Long id); // Add findById method
}
