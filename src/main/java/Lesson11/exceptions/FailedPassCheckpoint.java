package Lesson11.exceptions;

public class FailedPassCheckpoint extends RuntimeException {
    public FailedPassCheckpoint(String typeCar, String carNum) {
        super(typeCar + " не может проехать из-за несоответствия габаритам. Номер автомбиля " + carNum);
    }
}
