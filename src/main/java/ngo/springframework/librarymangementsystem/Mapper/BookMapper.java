package ngo.springframework.librarymangementsystem.Mapper;

import ngo.springframework.librarymangementsystem.DTOs.BookDTO;
import ngo.springframework.librarymangementsystem.model.Book;

public class BookMapper {
    public static BookDTO toBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthorName(book.getAuthor().getName());
        bookDTO.setCategoryName(book.getCategory().getName());
        return bookDTO;
    }
}
