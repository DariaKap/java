package Lesson17;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.List;
import java.util.concurrent.Callable;

@RequiredArgsConstructor
public class GetMaxOfList implements Callable<Double> {

    private final List<Integer> list;

    @Override
    @SneakyThrows
    public Double call() {
        Double result = list.get(0).doubleValue();
        for (Integer el:list) {
            result = result < el ? el : result;
        }
        System.out.println("Максимальное значение массива = " + result);
        return result;
    }
}
