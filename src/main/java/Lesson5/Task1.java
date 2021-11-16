package Lesson5;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number;
        String textForInput = "Введите положительное целое число для определения n-ого члена последовательности Фибоначчи. n = ";
        do {
            System.out.print(textForInput);
            while (!in.hasNextInt()) {
                System.out.print("Вы ввели не целое число!\n" + textForInput);
                in.next();
            }
            number = in.nextInt();
        } while (number < 0);
        System.out.printf("%d-й член последовательности Фибоначчи = %,d", number, getFibonacciElem(number));
    }

    /**
     * Получениние n-ого члена последовательности Фибоначчи
     *
     * @param num порядковое значение элемента
     * @return значение n-ого члена последовательности Фибоначчи
     */
    public static long getFibonacciElem(int num) {
        if (num == 0) {
            return 0;
        } else if (num < 2) {
            return 1;
        } else {
            return getFibonacciElem(num - 1) + getFibonacciElem(num - 2);
        }
    }
}
