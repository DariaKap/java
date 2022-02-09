package Lesson17;

import lombok.SneakyThrows;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecApiRunner {
    @SneakyThrows
    public static void main(String[] args) {

        List<Integer> array = IntStream.range(0, 1_000_000).boxed()
                .map(i -> new Random().nextInt(10000)-5000)
                .collect(Collectors.toList());
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Future<Double>> futures =
                executorService.invokeAll(List.of(new GetMaxOfList(array), new GetMinOfList(array), new GetAvgOfList(array)));
        for (Future<Double> f:futures) {
            System.out.println(f.get());
        }
        executorService.shutdown();
    }
}
