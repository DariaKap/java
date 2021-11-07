package Lesson2;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        String[] operations  = new String[4];
        operations[0] = "1. Сумма двух чисел";
        operations[1] = "2. Разница двух чисел";
        operations[2] = "3. Произведение двух чисел";
        operations[3] = "4. Деление двух чисел";

        Scanner in = new Scanner(System.in);
        System.out.println("Введите значения");
        System.out.print("A = ");
        int arg1 = in.nextInt();
        System.out.print("B = ");
        int arg2 = in.nextInt();

        // вывод списка операций
        System.out.println("Выберите одну из следующих операций:");
        for (String i:operations) {
            System.out.println(i);
        }

        String resTemplate = "Результат операции = ";
        // давать возможность выбрать операцию, пока не будет выбрана существующая
        boolean closeProg = false;

        while (!closeProg) {
            System.out.print("Введите номер операции: ");
            int num = in.nextInt();

            switch (num) {
                case 1:
                    System.out.println(resTemplate + (arg1 + arg2));
                    closeProg = true;
                    break;
                case 2:
                    System.out.println(resTemplate + (arg1 - arg2));
                    closeProg = true;
                    break;
                case 3:
                    System.out.println(resTemplate + (arg1 * arg2));
                    closeProg = true;
                    break;
                case 4:
                    if (arg2 == 0){
                        System.out.println("Делить на ноль нельзя!");
                    } else{
                        System.out.println(resTemplate + (arg1 / arg2));
                    }
                    closeProg = true;
                    break;
                default:
                    System.out.println("Выбрана несуществующая операция!");
                    break;
            }
        }
    }
}
