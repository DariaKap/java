package Lesson2;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        int resistanceForPutt = -3;

        System.out.println("Определение начальной скорости движения мяча, необходимой для попадания в лунку\n" +
                "Виды ударов : \n" +
                "1. Патт (катящийся удар, сопротивление = " + resistanceForPutt + " m/c^2)\n" +
                "2. Свинг (ударом под углом к горизонту)");
        System.out.print("Выберите удар по мячу : ");
        Scanner in = new Scanner(System.in);
        float num = in.nextInt();

        // запрашиваем входные данные для решения задачи
        System.out.print("Расстояние до лунки : ");
        float S = in.nextFloat();

        if (num == 1) {
            System.out.println(getSpeedPutt(S, resistanceForPutt));
        } else if (num == 2) {
            System.out.print("Угол удара : ");
            int angle = in.nextInt();
            System.out.println(getSpeedSwing(S, angle));

        } else {
            System.out.print("Неверно выбран тип удара! ");
        }
    }

    /**
     * Определение скорости при ударе патт
     *
     * @param S расстояние до лунки
     * @param a скорость
     */
    public static float getSpeedPutt(float S, float a) {
        return (float) Math.sqrt(-2 * a * S);
    }

    /**
     * Определение скорости при ударе свинг
     *
     * @param S     расстояние до лунки
     * @param angle скорость
     */
    public static float getSpeedSwing(float S, int angle) {
        float g = 9.8f;
        return (float) Math.sqrt((g * S) / Math.abs(Math.sin(2 * angle)));
    }
}
