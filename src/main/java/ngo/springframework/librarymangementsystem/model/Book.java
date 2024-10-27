package ngo.springframework.librarymangementsystem.model;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "category", nullable = false)
    private Category category;

}
