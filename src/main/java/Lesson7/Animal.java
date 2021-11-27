package Lesson7;

public class Animal {
    private int runLimit;
    private int swimLimit;
    private String name;

    public Animal(String name, int runLimit, int swimLimit) {
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void run(int distance) {
        int absDistance = Math.abs(distance);
        String result;
        if (absDistance <= runLimit && distance != 0) {
            result = " пробежал(а) " + absDistance + "м.";
        } else if (distance == 0) {
            result = " стоит на месте";
        } else {
            result = " не может пробежать " + absDistance + "м. Максимум " + this.runLimit + "м.";
        }
        System.out.println(this.name + result);
    }

    public void swim(int distance) {
        int absDistance = Math.abs(distance);
        String result;
        if (absDistance <= swimLimit && distance != 0) {
            result = " проплыл(а) " + absDistance + "м.";
        } else if (distance == 0) {
            result = " на месте";
        } else {
            result = " не может проплыть " + absDistance + "м. Максимум " + this.swimLimit + "м.";
        }
        System.out.println(this.name + result);
    }
}
