package lesson7;

public class Main {
    public static void main(String[] args) {

        Plate plate = new Plate(100);
        Cat[] catsArray = {
                new Cat("Murzik"),
                new Cat("Barsik"),
                new Cat("Vaska")
        };

        for (Cat cat : catsArray) {
            cat.eat(plate);
            plate.info();
        }
        Cat cat1 = new Cat("Fedor");
        cat1.eat(plate);
        plate.info();
        cat1.eat(plate);// проверка что один и тот же кот не может есть дважды
        plate.addFood(100);

    }
}
