package Lesson9;

public class AutoRunner {
    public static void main(String[] args) {
        Automobile[] automobiles = new Automobile[10];
        for (int i = 0; i < 10; i++) {
            if ((int) (Math.random() * 2) - 1 < 0){
                automobiles[i] = new Car();
            } else {
                automobiles[i] = new Truck();
            }
        }
        for (int i = 0; i < automobiles.length; i++) {
            automobiles[i].move((int) (Math.random() * 1000));
        }
    }
}
