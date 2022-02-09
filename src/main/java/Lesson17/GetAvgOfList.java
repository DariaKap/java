package Lesson17;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.Callable;

@RequiredArgsConstructor
public class GetAvgOfList implements Callable<Double> {

    private final List<Integer> list;

    @Override
    @SneakyThrows
    public Double call() {
        Double sum = 0d;
        for (Integer el:list) {
            sum += el;
        }
        Double result = sum / list.size();
        System.out.println("Среднее значение массива = " + result);
        return result;
    }
}