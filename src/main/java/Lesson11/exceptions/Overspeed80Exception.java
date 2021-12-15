package Lesson11.exceptions;

public class Overspeed80Exception extends RuntimeException {
    public Overspeed80Exception() {
        super("Автомобиль движется со скоростью свыше 80 км/ч");
    }
}
