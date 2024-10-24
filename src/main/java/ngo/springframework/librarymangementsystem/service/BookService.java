package ngo.springframework.librarymangementsystem.service;

import ngo.springframework.librarymangementsystem.DTOs.BookDTO;
import ngo.springframework.librarymangementsystem.Mapper.BookMapper;
import ngo.springframework.librarymangementsystem.model.Book;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface BookService {

    public List<BookDTO> searchBooksByAuthor(String authorName);

    public List<BookDTO> searchBooksByCategory(@RequestParam String categoryName);
    public List<BookDTO> searchBooksByAuthorAndCategory(@RequestParam String authorName,
                                                        @RequestParam String categoryName);
    List<BookDTO> getAllBooks();

    Optional<BookDTO> getBookById(Long id);

    Book createBook(Book book);

    Book updateBook(Long id, Book book);

    void deleteBook(Long id);
}
