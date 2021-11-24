package Lesson6;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count;
        String textForInput = "Введите положительное целое число для определения кол-ва элементов массива, " +
                "состоящего из рандомных чисел ";
        do {
            System.out.print(textForInput);
            while (!in.hasNextInt()) {
                System.out.print("Вы ввели не целое число!\n" + textForInput);
                in.next();
            }
            count = in.nextInt();
        } while (count <= 0);
        int[] array = new int[count];
        fillArrayRandom(array);

        System.out.println("Полученный массив : " + Arrays.toString(array));
        System.out.println("Минмальный элемент массива: " + getMinOfArray(array));
        System.out.println("Максимальный элемент массива: " + getMaxOfArray(array));
        System.out.println("Срднее значение массива: " + getAvgOfArray(array));
        System.out.println("-------------Через класс Arrays----------------");
        System.out.println("Минмальный элемент массива: " + Arrays.stream(array).min().getAsInt());
        System.out.println("Максимальный элемент массива: " + Arrays.stream(array).max().getAsInt());
        System.out.println("Срднее значение массива: " + Arrays.stream(array).average().getAsDouble());
    }

    /**
     * Заполнение массива рандомными числами от -100 до 100 включительно
     *
     * @param arr заполняемый массив
     */
    public static void fillArrayRandom(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Random random = new Random();
            arr[i] = (int) (Math.random() * 201 - 100);
        }
    }

    /**
     * Получение минимального элемента массива
     *
     * @param arr обрабатываемый массив
     * @return минимальное число
     */
    public static int getMinOfArray(int[] arr) {
        int minElem;
        minElem = arr[0];
        for (int i = 1; i < arr.length; i++) {
            minElem = minElem > arr[i] ? arr[i] : minElem;
        }
        return minElem;
    }


    /**
     * Получение максимального элемента массива
     *
     * @param arr обрабатываемый массив
     * @return максимальное число
     */
    public static int getMaxOfArray(int[] arr) {
        int maxElem;
        maxElem = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxElem = maxElem < arr[i] ? arr[i] : maxElem;
        }
        return maxElem;
    }


    /**
     * Получение среднего значения массива
     *
     * @param arr обрабатываемый массив
     * @return среднее значение
     */
    public static float getAvgOfArray(int[] arr) {
        int average = 0;
        for (int i = 0; i < arr.length; i++) {
            average += arr[i];
        }
        return (float) average / arr.length;
    }
}

