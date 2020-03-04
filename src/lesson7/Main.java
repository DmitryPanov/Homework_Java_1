package lesson7;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik");
        Plate plate =new Plate(10);

        cat1.eat(plate);
        plate.info();
        cat1.eat(plate);
        plate.info();
    }
}
