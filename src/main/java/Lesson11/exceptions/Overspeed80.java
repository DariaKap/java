package Lesson11.exceptions;

public class Overspeed80 extends RuntimeException {
    public Overspeed80() {
        super("Автомобиль движется со скоростью свыше 80 км/ч");
    }
}
