package Lesson11.exceptions;

public class Overspeed100Exception extends RuntimeException {

    public Overspeed100Exception(String carNumber) {
        super("Автомобиль движется со скоростью свыше 100 км/ч. " +
                "Полиция ищет преступника на машине с номером автомобиля " + carNumber);
    }
}
