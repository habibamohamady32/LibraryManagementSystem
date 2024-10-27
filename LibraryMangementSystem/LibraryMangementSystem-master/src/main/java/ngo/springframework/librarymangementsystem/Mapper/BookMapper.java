package ngo.springframework.librarymangementsystem.Mapper;

import ngo.springframework.librarymangementsystem.DTOs.BookDTO;
import ngo.springframework.librarymangementsystem.model.Book;

public class BookMapper {
    public static BookDTO toDTO(Book book) {
        if (book == null) {
            return null;
        }
        BookDTO dto = new BookDTO();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setAuthor(AuthorMapper.authorToDTO(book.getAuthor()));
        dto.setCategory(CategoryMapper.toDTO(book.getCategory()));
        return dto;
    }

    public static Book toEntity(BookDTO dto) {
        if (dto == null) {
            return null;
        }
        Book book = new Book();
        book.setId(dto.getId());
        book.setTitle(dto.getTitle());
        book.setAuthor(AuthorMapper.dtoToAuthor(dto.getAuthor())); // Ensure AuthorMapper is correct
        book.setCategory(CategoryMapper.toEntity(dto.getCategory())); // Ensure CategoryMapper is correct
        return book;
    }
}
