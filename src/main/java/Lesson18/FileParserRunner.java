package Lesson18;

import Lesson13.EmployeeRunner;
import lombok.SneakyThrows;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileParserRunner {

    private static final String FILE_LOCATION = "/file.txt";

    @SneakyThrows({IOException.class})
    public static void main(String[] args) {

        final String fileNamePrefix = "Строка";
        String line;
        int serialNumber = 0;

        InputStream inputStream = EmployeeRunner.class.getResourceAsStream(FILE_LOCATION);

        if (inputStream == null) {
            System.out.println("Файл для чтения не найден");
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            while ((line = br.readLine()) != null) {
                writeInNewFile(line, fileNamePrefix + "_" + ++serialNumber + ".txt");
            }
        }
        System.out.println("Обработка файла завершена");
    }

    @SneakyThrows({IOException.class})
    public static void writeInNewFile(String line, String fileName) {
        Path path = Paths.get("G:\\newFilesOfLeeson18", fileName);
        Path parentPath = path.getParent();

        if (!Files.exists(parentPath)) {
            System.out.println("Создана директория " + parentPath);
            Files.createDirectories(parentPath);
        }

        if (Files.deleteIfExists(path)){
            System.out.println("Перед записью файл " + fileName +" был удален");
        }

        Files.writeString(path,
                line,
                StandardOpenOption.CREATE,
                StandardOpenOption.WRITE
        );
    }
}
