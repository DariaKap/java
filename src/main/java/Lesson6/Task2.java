package Lesson6;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {


    public static void main(String[] args) {
        long[] fibCache = new long[51];
        Arrays.fill(fibCache, -1);
        fibCache[0] = 0;
        fibCache[1] = 1;

        Scanner in = new Scanner(System.in);
        int number;

        String textForInput = "Получение n-ого элемента последовательности Фибоначчи, для выхода введите exit\n";
        textForInput += "Введите число от 0 до 50. n = ";

        while (true) {
            do {
                System.out.print(textForInput);
                while (!in.hasNextInt() && !in.hasNext("exit")) {
                    System.out.print(textForInput);
                    in.next();
                }
                if (in.hasNext("exit")) {
                    return;
                }
                number = in.nextInt();
            } while (number < 0 || number > 50);

            long result = getFibonacciElem(number, fibCache);
            System.out.printf("%d-й член последовательности Фибоначчи = %,d\n", number, result);
          //  System.out.println("Состояние кэша " + Arrays.toString(fibCache));
        }
    }

    /**
     * Получениние n-ого члена последовательности Фибоначчи
     *
     * @param num порядковое значение элемента
     * @return значение n-ого члена последовательности Фибоначчи, в случае ошибки -1
     */
    public static long getFibonacciElem(int num, long[] cache) {
        if (cache.length > num) {
            if (cache[num] != -1) {
                return cache[num];
            }
            int beginEl = getArrayIndex(cache, -1);
            for (int i = beginEl; i <= num; i++) {
                cache[i] = cache[i - 1] + cache[i - 2];
            }
            return cache[num];
        } else {
            return -1;
        }
    }

    /**
     * Находим индекс первого подходящего элемента массива
     *
     * @param arr   массив элементов
     * @param value значение, которое ищем в массиве
     * @return индекс элемента, если не найден -1
     */
    public static int getArrayIndex(long[] arr, long value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}

