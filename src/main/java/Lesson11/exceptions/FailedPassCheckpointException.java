package Lesson11.exceptions;

public class FailedPassCheckpointException extends RuntimeException {
    public FailedPassCheckpointException(String typeCar, String carNum) {
        super(typeCar + " не может проехать из-за несоответствия габаритам. Номер автомбиля " + carNum);
    }
}
