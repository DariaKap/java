package Lesson4;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number;
        String textForInput = "Введите положительное целое число для определения квадратного корня. N = ";
        do {
            System.out.print(textForInput);
            while (!in.hasNextInt()) {
                System.out.print("Вы ввели не целое число!\n" + textForInput);
                in.next();
            }
            number = in.nextInt();
        } while (number <= 0);
        System.out.printf("Квадратный корень из %d = %.2f", number, getSquareRootOfNumber(number));
    }

    /**
     * Нахождение квадратного корня по формуле Ньютона
     *
     * @param Number число для получения квадратного корня
     * @return квадратный корень числа
     */
    public static double getSquareRootOfNumber(int Number) {
        double num;
        double root;
        if (Number == 1) {
            root = 1;
        } else {
            // возьмем первое приближенное значение корня - половина от числа
            // можно взять 1, но будет больше итераций
            root = Number / 2f;
            do {
                num = root;
                root = 0.5 * (root + Number / root);
            } while ((num - root) != 0);
        }
        return root;
    }
}
