package ngo.springframework.librarymangementsystem.service;

import ngo.springframework.librarymangementsystem.DTOs.AuthorDTO;
import ngo.springframework.librarymangementsystem.Mapper.AuthorMapper;
import ngo.springframework.librarymangementsystem.model.Author;
import ngo.springframework.librarymangementsystem.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public AuthorDTO getAuthorById(Long id) {
        return authorRepository.findById(id)
                .map(AuthorMapper::authorToDTO)
                .orElseThrow();
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        return authorRepository.findAll().stream()
                .map(AuthorMapper::authorToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Author updateAuthor(Long id, Author author) {
        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow();

        existingAuthor.setName(author.getName());
        return authorRepository.save(existingAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {

        authorRepository.deleteById(id);
    }

    @Override
    public Author findById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow();
    }


}
