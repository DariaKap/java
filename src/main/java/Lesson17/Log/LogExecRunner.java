package Lesson17.Log;

import Lesson16.LoggingLevel;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LogExecRunner {
    @SneakyThrows
    public static void main(String[] args) {
        Path logPath = Paths.get("logExecApi.txt");

        if (Files.exists(logPath)) {
            System.out.println("Удалён старый log-файл");
            Files.delete(logPath);
        }

        final LoggingLevel[] levels = LoggingLevel.values();
        Stack<Thread> stackThread = new Stack<>();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<Void>> threadList= IntStream.range(0,3).boxed()
                .map(i -> new Logger(levels[new Random().nextInt(levels.length)], logPath))
                .collect(Collectors.toList());
        executorService.invokeAll(threadList);
        executorService.shutdown();
        System.out.println("--------------Лог файл--------------");
        System.out.println(Files.readString(logPath));
    }
}
