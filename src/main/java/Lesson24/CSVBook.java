package Lesson24;

import com.opencsv.bean.CsvToBeanBuilder;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;

public class CSVBook {
    @SneakyThrows
    public static List<Book> getBooks(Path path){
        FileReader fileReader = new FileReader(path.toString());
        List<Book> beans = new CsvToBeanBuilder<Book>(fileReader)
                .withType(Book.class)
                .withSeparator(';')
                .build()
                .parse();
        return beans;
    }
}
