package ngo.springframework.librarymangementsystem.service;

import ngo.springframework.librarymangementsystem.DTOs.BookDTO;
import ngo.springframework.librarymangementsystem.Mapper.BookMapper;
import ngo.springframework.librarymangementsystem.model.Book;
import ngo.springframework.librarymangementsystem.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> searchBooksByAuthor(String authorName) {
        return bookRepository.findByAuthor_Name(authorName)
                .stream()
                .map(BookMapper::toDTO) // Corrected to use toDTO
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> searchBooksByCategory(String categoryName) {
        return bookRepository.findByCategory_Name(categoryName)
                .stream()
                .map(BookMapper::toDTO) // Corrected to use toDTO
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> searchBooksByAuthorAndCategory(String authorName, String categoryName) {
        return bookRepository.findByAuthor_NameAndCategory_Name(authorName, categoryName)
                .stream()
                .map(BookMapper::toDTO) // Corrected to use toDTO
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toDTO) // Corrected to use toDTO
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BookDTO> getBookById(Long id) {
        return bookRepository.findById(id).map(BookMapper::toDTO);
    }

    @Override
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow();

        existingBook.setTitle(book.getTitle());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setCategory(book.getCategory());
        return bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long id) {

        bookRepository.deleteById(id);
    }
}
