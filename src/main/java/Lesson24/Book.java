package Lesson24;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @CsvBindByName
    private String isbn;
    @CsvBindByName
    private String author;
    @CsvBindByName
    private String name;
    @CsvBindByName
    private String genre;
    @CsvBindByName
    private String publisher;
    @CsvBindByName
    private String year;
    @CsvBindByName
    private int pages;
    @CsvBindByName
    private String url;

}
