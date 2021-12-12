package Lesson11;

import java.util.regex.Pattern;

public class CheckPointRunner {
    public static void main(String[] args) {
        int numOfCar = 10;
        Automobile[] automobiles = new Automobile[numOfCar];

        automobiles[0] = new Truck(Automobile.generateCarNumber(), 3.5f, 2.2f, 2.3f, 5.2f);
        automobiles[1] = new Truck(Automobile.generateCarNumber(), 15f, 2.45f, 2.5f, 13.6f);
        automobiles[2] = new Truck(Automobile.generateCarNumber(), 5f, 2.0f, 2.2f, 6.7f);
        automobiles[3] = new Truck(Automobile.generateCarNumber(), 25f, 2.45f, 3.7f, 11.7f);
        automobiles[4] = new Truck(Automobile.generateCarNumber(), 12f, 2f, 3.2f, 12f);
        automobiles[5] = new Car(Automobile.generateCarNumber(), 1.24f, 1.7f, 1.47f, 4.4f);
        automobiles[6] = new Car(Automobile.generateCarNumber(), 1.19f, 1.75f, 1.53f, 4.2f);
        automobiles[7] = new Car(Automobile.generateCarNumber(), 2.2f, 1.9f, 1.4f, 5.17f);
        automobiles[8] = new Car(Automobile.generateCarNumber(), 1.35f, 1.75f, 1.43f, 4.6f);
        automobiles[9] = new Car(Automobile.generateCarNumber(), 1.15f, 1.73f, 1.46f, 4.4f);

        for (int i = 0; i < 10; i++) {
            System.out.println("Автомобиль " + (i + 1));
            try {
                automobiles[i].setSpeed((int) (Math.random() * 70 + 50));
                CheckPont.check(automobiles[i]);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
