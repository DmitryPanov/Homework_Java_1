package Lesson6;

import Lesson6.Animals.*;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik");
        cat1.run(-20);
        cat1.swim(10);
        cat1.jump(1.5);

        Animal animal1 = new Animal("Zorka");
        animal1.jump(1.5);
        animal1.run(50);
        animal1.swim(250);

        Dog dog1 = new Dog("Bob",400);
        dog1.jump(0.3);
        dog1.swim(5);
        dog1.run(399);

        Animal animal2  = new Animal("Marty");
        animal2.jump(1.5);

        Cat cat2 = new Cat("Mursik");
    }
}
