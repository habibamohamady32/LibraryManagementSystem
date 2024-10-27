package ngo.springframework.librarymangementsystem.DTOs;

import lombok.Data;
import ngo.springframework.librarymangementsystem.model.Category;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private AuthorDTO author;
    private CategoryDTO category;


}
