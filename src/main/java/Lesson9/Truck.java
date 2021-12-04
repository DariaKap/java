package Lesson9;

public class Truck extends Automobile {

    public Truck() {
        super(1200);
    }


    void move(int moveDistance) {
        int absDistance = Math.abs(moveDistance);
        if (absDistance <= this.distance) {
            System.out.println("Грузовик проехал расстояние " + absDistance + " км.");
        } else {
            System.out.println("Грузовик не может проехать расстояние " + absDistance + " км. Максимум "
                    + this.distance + " км.");
        }
    }
}
