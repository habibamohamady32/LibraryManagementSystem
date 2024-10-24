package ngo.springframework.librarymangementsystem.controller;

import ngo.springframework.librarymangementsystem.DTOs.AuthorDTO;
import ngo.springframework.librarymangementsystem.model.Author;
import ngo.springframework.librarymangementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<AuthorDTO> getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        return authorService.updateAuthor(id, author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }

}
