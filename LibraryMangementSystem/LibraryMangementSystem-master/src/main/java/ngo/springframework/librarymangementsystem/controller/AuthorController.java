package ngo.springframework.librarymangementsystem.controller;

import ngo.springframework.librarymangementsystem.DTOs.AuthorDTO;
import ngo.springframework.librarymangementsystem.Mapper.AuthorMapper;
import ngo.springframework.librarymangementsystem.model.Author;
import ngo.springframework.librarymangementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable Long id) {
        AuthorDTO authorDTO = authorService.getAuthorById(id); // Use the service method directly
        return ResponseEntity.ok(authorDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        Author author = AuthorMapper.dtoToAuthor(authorDTO); // Use correct mapper method
        Author savedAuthor = authorService.createAuthor(author); // Call createAuthor method
        AuthorDTO savedAuthorDTO = AuthorMapper.authorToDTO(savedAuthor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAuthorDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Long id, @RequestBody AuthorDTO authorDTO) {
        Author author = AuthorMapper.dtoToAuthor(authorDTO); // Convert DTO to entity
        Author updatedAuthor = authorService.updateAuthor(id, author);
        AuthorDTO updatedAuthorDTO = AuthorMapper.authorToDTO(updatedAuthor);
        return ResponseEntity.ok(updatedAuthorDTO); // Return updated DTO
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content on successful deletion
    }
}
