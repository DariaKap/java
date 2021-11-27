package Lesson7;

public class AnimalsRunner {

    public static void main(String[] args) {
        Dog myDog = new Dog("Бобик");
        System.out.println("Собаку зовут " + myDog.getName());
        myDog.run(0);
        myDog.run(600);
        myDog.run(100);
        myDog.swim(0);
        myDog.swim(5);
        myDog.swim(12);
        System.out.println("--------------------------");

        Cat myCat = new Cat("Барсик");
        System.out.println("Кота зовут " + myCat.getName());
        myCat.run(0);
        myCat.run(210);
        myCat.run(100);
        myCat.swim(0);
        myCat.swim(5);
        System.out.println("--------------------------");

        Tiger cookie = new Tiger("Печенька");
        System.out.println("Тигра зовут " + cookie.getName());
        cookie.run(0);
        cookie.run(700);
        cookie.run(100);
        cookie.swim(0);
        cookie.swim(12);
        cookie.swim(20);
        System.out.println("--------------------------");
    }
}
