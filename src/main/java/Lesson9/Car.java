package Lesson9;

public final class Car extends Automobile {

    public Car() {
        super(500);
    }


    void move(int moveDistance) {
        int absDistance = Math.abs(moveDistance);
        if (absDistance <= this.distance) {
            System.out.println("Машина проехала расстояние " + absDistance + " км.");
        } else {
            System.out.println("Машина не может проехать расстояние " + absDistance + " км. Максимум "
                    + this.distance + " км.");
        }
    }
}
