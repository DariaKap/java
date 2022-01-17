package Lesson16;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;

public class LogRunner {

    public static void main(String[] args) throws Exception {

        Path logPath = Paths.get("log.txt");

        if (Files.exists(logPath)) {
            System.out.println("Удалён старый log-файл");
            Files.delete(logPath);
        }

        final LoggingLevel[] levels = LoggingLevel.values();

        for (int i = 0; i < 3; i++) {
            Runnable runnable  = new Logger(levels[new Random().nextInt(levels.length)], logPath);
            new Thread(runnable).start();
        }
    }
}
