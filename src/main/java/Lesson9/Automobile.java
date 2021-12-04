package Lesson9;

abstract class Automobile {

    protected int distance;

    public Automobile(int distance) {
        this.distance = distance;
    }

    abstract void move(int moveDistance);
}
