package Lesson16;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class LogRunner {

    public static void main(String[] args) throws Exception {

        Path logPath = Paths.get("log.txt");

        if (Files.exists(logPath)) {
            System.out.println("Удалён старый log-файл");
            Files.delete(logPath);
        }

        final LoggingLevel[] levels = LoggingLevel.values();
        Stack<Thread> stackThread = new Stack<>();
        for (int i = 0; i < 3; i++) {
            stackThread.add(new Thread(new Logger(levels[new Random().nextInt(levels.length)], logPath)));
            stackThread.peek().start();
        }
        for (Thread thread : stackThread) {
            thread.join();
        }
        System.out.println("--------------Лог файл--------------");
        System.out.println(Files.readString(logPath));
    }
}
