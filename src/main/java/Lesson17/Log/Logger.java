package Lesson17.Log;

import Lesson16.LoggingLevel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;

@RequiredArgsConstructor
public class Logger implements Callable<Void> {

    private static final DateTimeFormatter FULL_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss.SSS");

    private final LoggingLevel level;
    private final Path path;
    private final LocalDateTime currentTime = LocalDateTime.now();

    @Override
    @SneakyThrows
    public Void call() {
        System.out.println("Начал работу поток " + Thread.currentThread().getName());
        while (Duration.between(currentTime, LocalDateTime.now()).toMinutes() < 1) { // время работы потока ограничено 1 минутой
            Files.writeString(path,
                    getMessage(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
            Thread.sleep(new Random().nextInt(5_000));
        }
        // возвращает имя потока, который выполняет callable таск
        return null;
    }

    private String getMessage() {
        return LocalDateTime.now().format(FULL_DATE_TIME_FORMAT) + "\t" +
                level + "\t" + Thread.currentThread().getName() + "\t" +
                "Рандомное сообщение " + new Random().nextInt(5_000) + "\n";
    }
}
