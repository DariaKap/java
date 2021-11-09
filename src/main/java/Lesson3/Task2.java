package Lesson3;

import java.math.BigInteger;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Введите число для расчета факториала\nn = ");
        int n = in.nextInt();

        if (n < 0) {
            System.out.println("Факториал расссчитывается только для натуральных чисел");
        } else {
            BigInteger factorial = getFactorial(n);
            System.out.printf("%d! = %,d", n, factorial);
        }
    }

    public static BigInteger getFactorial(int f) {
        if (f <= 1) {
            return BigInteger.valueOf(1);
        } else {
            return BigInteger.valueOf(f).multiply(getFactorial(f - 1));
        }
    }
}
