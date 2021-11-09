package Lesson3;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        System.out.println("Решение полного квадратного уравнения: ax^2 + bx + c = 0");

        boolean closeProgram = false;

        while (!closeProgram) {
            System.out.println("Введите коэффиценты");
            Scanner in = new Scanner(System.in);
            float coefA = 0;
            boolean firstAttempt = true;
            // просим ввести первый коэффицент пока не введут значение не равное 0
            while (coefA == 0) {
                if (!firstAttempt) {
                    System.out.println("Первый коэффициент не может быть 0");
                }
                System.out.print("a = ");
                coefA = in.nextFloat();
                firstAttempt = false;
            }

            System.out.print("b = ");
            float coefB = in.nextFloat();
            System.out.print("c = ");
            float coefC = in.nextFloat();


            float determinant = (float) Math.pow(coefB, 2) - 4 * coefA * coefC;
            System.out.printf("D = %.2f\n", determinant);
            float root1;
            float root2;

            if (determinant < 0) {
                System.out.println("Нет действительных решений уравнения");
            } else if (determinant == 0) {
                root1 = -coefB / 2;
                System.out.printf("Один корень: x = %.2f\n", root1);
            } else {
                root1 = (float) ((-coefB + Math.sqrt(determinant)) / 2);
                root2 = (float) ((-coefB - Math.sqrt(determinant)) / 2);
                System.out.printf("Два корня: %.2f , %.2f\n", root1, root2);
            }

            System.out.println("Хотите решить еще одно уравнение? y/n");
            String console = in.next();
            if (console.equals("n")) {
                closeProgram = true;
            }
        }
    }
}
