package ngo.springframework.librarymangementsystem.controller;

import lombok.RequiredArgsConstructor;
import ngo.springframework.librarymangementsystem.DTOs.BookDTO;
import ngo.springframework.librarymangementsystem.model.Book;
import ngo.springframework.librarymangementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search/author")
    public List<BookDTO> searchBooksByAuthor(@RequestParam String authorName) {
        return bookService.searchBooksByAuthor(authorName);
    }

    @GetMapping("/search/category")
    public List<BookDTO> searchBooksByCategory(@RequestParam String categoryName) {
        return bookService.searchBooksByCategory(categoryName);
    }

    @GetMapping("/search")
    public List<BookDTO> searchBooksByAuthorAndCategory(@RequestParam String authorName,
                                                        @RequestParam String categoryName) {
        return bookService.searchBooksByAuthorAndCategory(authorName, categoryName);
    }


    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Optional<BookDTO> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

}
