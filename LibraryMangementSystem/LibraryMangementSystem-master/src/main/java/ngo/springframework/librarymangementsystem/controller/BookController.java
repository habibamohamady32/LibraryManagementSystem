package ngo.springframework.librarymangementsystem.controller;

import lombok.RequiredArgsConstructor;
import ngo.springframework.librarymangementsystem.DTOs.BookDTO;
import ngo.springframework.librarymangementsystem.Mapper.BookMapper;
import ngo.springframework.librarymangementsystem.model.Book;
import ngo.springframework.librarymangementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

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
    public ResponseEntity<BookDTO> getBook(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        Book book = BookMapper.toEntity(bookDTO);
        Book savedBook = bookService.createBook(book);
        BookDTO savedBookDTO = BookMapper.toDTO(savedBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBookDTO);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        Book book = BookMapper.toEntity(bookDTO);
        Book updatedBook = bookService.updateBook(id, book);
        return ResponseEntity.ok(BookMapper.toDTO(updatedBook));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
