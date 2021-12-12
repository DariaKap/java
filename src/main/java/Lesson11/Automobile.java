package Lesson11;

import Lesson11.enums.CheckSpeedValues;
import Lesson11.exceptions.Overspeed100;
import Lesson11.exceptions.Overspeed80;

import java.util.ArrayList;

abstract class Automobile {
    static final String simbols = "АВЕКМНОРСТУХ";
    static final char[] availableChar = simbols.toCharArray();

    public static ArrayList<String> carNumbers = new ArrayList<>();

    private final String typeCar;
    private String carNumber;
    private int speed;

    private final float weight;

    private final float width;
    private final float height;
    private final float length;

    public Automobile(String typeCar, String carNumber, float weight, float width, float height, float length) {
        if (carNumber == null || !(carNumber.matches(String.format("[%s](\\d){3}([%s]){2}", Automobile.simbols,Automobile.simbols)))
                || weight <= 0 || width <= 0 || height <= 0 || length <= 0) {
            throw new IllegalArgumentException("Введены недопустимые параметры автомобиля");
        }
        this.typeCar = typeCar;
        this.carNumber = carNumber;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
        if (speed > CheckSpeedValues.SPEEDLIMIT100.getValue()) {
            throw new Overspeed100(getCarNumber());
        } else if (speed > CheckSpeedValues.SPEEDLIMIT80.getValue()) {
            throw new Overspeed80();
        }
        System.out.println("Нарушения скорости нет");
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int getSpeed() {
        return speed;
    }

    public float getWeight() {
        return weight;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public float getLength() {
        return length;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public static String generateCarNumber() {
        String result;
        do {
            result = Character.toString(availableChar[(int) (Math.random() * 12)]) + (int) (Math.random() * 900 + 100)
                    + availableChar[(int) (Math.random() * 12)] + availableChar[(int) (Math.random() * 12)];
        } while (carNumbers.contains(result));
        carNumbers.add(result);
        return result;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "typeCar='" + typeCar + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", speed=" + speed +
                ", weight=" + weight +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                '}';
    }
}
