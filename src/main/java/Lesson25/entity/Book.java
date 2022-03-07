package Lesson25.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="books")
public class Book {
    @Id
    private int id;
    private String isbn;
    private String name;
    @ManyToOne
    @JoinColumn(name="author_id")
    private Author author;
    @ManyToOne
    @JoinColumn(name="genre_id")
    private Genre genre;
    @ManyToOne
    @JoinColumn(name="publisher_id")
    private Publisher publisher;
    private String year;
    @Column(name="num_of_pages")
    private int numOfPages;
}
