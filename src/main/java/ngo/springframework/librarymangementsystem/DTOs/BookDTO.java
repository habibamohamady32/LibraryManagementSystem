package ngo.springframework.librarymangementsystem.DTOs;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String authorName;
    private String categoryName;


}
